package com.intelliinvest.server.services;

import com.intelliinvest.server.payloads.MessageDto;

import java.util.List;

public interface MessageService {
    MessageDto createMessage(MessageDto messageDto);
    void deleteMessage(Integer id);
    List<MessageDto> getAllMessage();
}
