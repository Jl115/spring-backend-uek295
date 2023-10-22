package com.example.uek295_backeend.channel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    // GET Mapping to retrieve all channels
    @GetMapping("/")
    public ResponseEntity<String> getChannels() {
        return ResponseEntity.ok("All channels data");
    }

    // GET Mapping to retrieve detailed information about a specific channel by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getChannelById(@PathVariable String id) {
        return ResponseEntity.ok("Channel details for ID: " + id);
    }

    // POST Mapping to create a new channel with information about both users
    @PostMapping("/")
    public ResponseEntity<String> postChannel(@RequestBody String channelInfo) {
        return ResponseEntity.status(201).body("Channel created with info: " + channelInfo);
    }

    // DELETE Mapping to delete a specific channel by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChannel(@PathVariable String id) {
        // Perform deletion logic here
        return ResponseEntity.noContent().build();
    }
}
