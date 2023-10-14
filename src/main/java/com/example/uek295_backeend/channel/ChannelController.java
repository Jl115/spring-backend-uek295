package com.example.uek295_backeend.channel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    // GET Mapping to retrieve all channels
    @GetMapping("/")
    public String getChannels() {
        return "All channels data";
    }

    // GET Mapping to retrieve detailed information about a specific channel by ID
    @GetMapping("/{id}")
    public String getChannelById(@PathVariable String id) {
        return "Channel details for ID: " + id;
    }

    // POST Mapping to create a new channel with information about both users
    @PostMapping("/")
    public String postChannel(@RequestBody String channelInfo) {
        return "Channel created with info: " + channelInfo;
    }

    // DELETE Mapping to delete a specific channel by ID
    @DeleteMapping("/{id}")
    public String deleteChannel(@PathVariable String id) {
        return "Channel with ID " + id + " deleted";
    }
}
