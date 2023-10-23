package com.example.uek295_backeend.channel;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")  // Only the involved users or an admin can access the details
    public ResponseEntity<String> getChannelById(@PathVariable String id) {
        return ResponseEntity.ok("Channel details for ID: " + id);
    }

    // POST Mapping to create a new channel with information about both users
    @PostMapping("/")
    @PreAuthorize("isAuthenticated()")  // Ensure the user is authenticated to create a channel
    public ResponseEntity<String> postChannel(@RequestBody String channelInfo) {
        return ResponseEntity.status(201).body("Channel created with info: " + channelInfo);
    }

    // DELETE Mapping to delete a specific channel by ID
    @DeleteMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")  // Only the involved users or an admin can delete the channel
    public ResponseEntity<Void> deleteChannel(@PathVariable String id) {
        // Perform deletion logic here
        return ResponseEntity.noContent().build();
    }
}
