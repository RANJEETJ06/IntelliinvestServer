package com.intelliinvest.server.controllers;

import com.intelliinvest.server.entities.User;
import com.intelliinvest.server.payloads.ApiResponse;
import com.intelliinvest.server.payloads.LoginDTO;
import com.intelliinvest.server.payloads.UserDto;
import com.intelliinvest.server.repositories.UserRepo;
import com.intelliinvest.server.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto CreatedUserDto=this.userService.createUser(userDto);
        return new ResponseEntity<>(CreatedUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        UserDto UpdatedUserDto=this.userService.updateUser(userDto);
        return ResponseEntity.ok(UpdatedUserDto);
    }

    @DeleteMapping("/delete/{id}/")
    public ResponseEntity<?> deleteUser( @PathVariable Integer id){
        this.userService.DeleteUser(id);
        return new ResponseEntity<>(Map.of("Message","Deleted successfully"),HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}/")
    public ResponseEntity<UserDto> GetUser(@PathVariable String id){
        UserDto user=this.userService.getUser(Integer.valueOf(id));
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> GetAllUser(){
        List<UserDto> users= this.userService.getAll();
        return new ResponseEntity<>(users,HttpStatus.CREATED);
    }
    @PostMapping("/login/")
    public ResponseEntity<ApiResponse> signIn(@RequestBody LoginDTO loginDTO) {
        String email = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        UserDto user= this.modelMapper.map(this.userRepo.findByEmail(email),UserDto.class);
        if (user!=null) {
            if (password.equals(user.getPassword())) {
                return new ResponseEntity<>(new ApiResponse("Login successful", true,user.getId()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ApiResponse("Incorrect password", false,null), HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(new ApiResponse("User not found",false,null), HttpStatus.FORBIDDEN);
        }
    }
}
