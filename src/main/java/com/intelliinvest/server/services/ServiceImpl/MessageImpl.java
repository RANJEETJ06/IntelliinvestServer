package com.intelliinvest.server.services.ServiceImpl;

import com.intelliinvest.server.entities.Message;
import com.intelliinvest.server.payloads.MessageDto;
import com.intelliinvest.server.repositories.MessageRepo;
import com.intelliinvest.server.services.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageImpl implements MessageService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MessageRepo messageRepo;

    @Override
    public MessageDto createMessage(MessageDto messageDto) {
        System.out.println(messageDto.getMessage());
        Message entity = this.DtoToMessage(messageDto);
        Message saved = this.messageRepo.save(entity);
        return this.MessageToDto(saved);
    }

    @Override
    public void deleteMessage(Integer id) {
        this.messageRepo.delete(this.messageRepo.getReferenceById(id));
    }

    @Override
    public List<MessageDto> getAllMessage() {
        return this.messageRepo.findAll().stream().map(this::MessageToDto).collect(Collectors.toList());
    }

    public MessageDto MessageToDto(Message messages){
        return this.modelMapper.map(messages,MessageDto.class);
    }
    public Message DtoToMessage(MessageDto messageDto){
        return this.modelMapper.map(messageDto, Message.class);
    }
}
