package com.intelliinvest.server.services.ServiceImpl;

import com.intelliinvest.server.entities.User;
import com.intelliinvest.server.exceptions.ResourcesNotFoundException;
import com.intelliinvest.server.payloads.UserDto;
import com.intelliinvest.server.repositories.UserRepo;
import com.intelliinvest.server.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User saved=this.userRepo.save(this.dtoToUser(userDto));
        return this.userToDto(saved);
    }

    @Override
    public UserDto getUser(Integer id) {
        User user=this.userRepo.findById(id).orElseThrow(()->new ResourcesNotFoundException("User","User mail",id));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return this.userRepo.findAll().stream().map(this::userToDto).collect(Collectors.toList());
    }

    @Override
    public void DeleteUser(Integer id) {
        User user=this.userRepo.findById(id).orElseThrow(()->new ResourcesNotFoundException("User","User mail",id));
        this.userRepo.delete(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user=this.userRepo.findById(userDto.getId()).orElseThrow(()->new ResourcesNotFoundException("User","User mail",userDto.getId()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setCountry(userDto.getCountry());
        user.setPIN(userDto.getPIN());
        return this.userToDto(this.userRepo.save(user));
    }
    public UserDto userToDto(User user){
        return this.modelMapper.map(user,UserDto.class);
    }
    public User dtoToUser(UserDto userDto){
        return this.modelMapper.map(userDto,User.class);
    }
}
