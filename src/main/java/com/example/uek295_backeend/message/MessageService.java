package com.example.uek295_backeend.message;

import com.example.uek295_backeend.message.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    Message create(Message message);

    Message getById(Long id);

    List<Message> getAll();

    Message update(Long id, Message message);

    void delete(Long id);
}
