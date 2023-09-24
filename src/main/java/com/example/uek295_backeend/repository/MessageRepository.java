package com.example.uek295_backeend.repository;

import com.example.uek295_backeend.entity.Message;
import com.example.uek295_backeend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByFromUser(User fromUser);
    List<Message> findAllByToUser(User user);
}


