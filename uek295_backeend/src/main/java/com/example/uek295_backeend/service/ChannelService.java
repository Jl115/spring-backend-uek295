package com.example.uek295_backeend.service;

import com.example.uek295_backeend.entity.Category;
import com.example.uek295_backeend.entity.Channel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChannelService {
    Channel create(Channel channel);

    Channel getById(Long id);

    List<Channel> getAll();

    Channel update(Long id, Channel channel);

    void delete(Long id);
}
