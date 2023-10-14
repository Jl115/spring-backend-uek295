package com.example.uek295_backeend.channel;

import com.example.uek295_backeend.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    List<Channel> findAllByName(String name);
}


