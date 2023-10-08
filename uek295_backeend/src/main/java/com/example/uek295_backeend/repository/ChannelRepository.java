package com.example.uek295_backeend.repository;

import com.example.uek295_backeend.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    List<Channel> findAllByName(String name);
}


