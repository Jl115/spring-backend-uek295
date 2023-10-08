package com.example.uek295_backeend.service.implementation;

import com.example.uek295_backeend.entity.Message;
import com.example.uek295_backeend.repository.MessageRepository;
import com.example.uek295_backeend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImplementation implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message create(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message getById(Long id) {
        return messageRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Message with ID: " + id + " not found"));
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message update(Long id, Message messageToUpdate) {
        Message message = messageRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Message with ID: " + id + " not found"));

        //Updating messages
        message.setMessageContent(messageToUpdate.getMessageContent());

        return messageRepository.save(message);
    }

    @Override
    public void delete(Long id) {
        if (!messageRepository.existsById(id.intValue())){
            throw new ResourceNotFoundException("Message with ID: " + id + " not found");
        }
        messageRepository.deleteById(id.intValue());
    }
}
