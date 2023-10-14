package com.example.uek295_backeend.message;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel/{channelId}/message")
public class MessageController {

    // GET Mapping to retrieve a specific message by its ID in a specific channel
    @GetMapping("/{messageId}")
    public String getMessage(@PathVariable String channelId, @PathVariable String messageId) {
        return "Message details - Channel ID: " + channelId + ", Message ID: " + messageId;
    }

    // GET Mapping to retrieve all messages in a specific channel
    @GetMapping("/")
    public String getMessages(@PathVariable String channelId) {
        return "All messages data for Channel ID: " + channelId;
    }

    // POST Mapping to create a new message in a specific channel
    @PostMapping("/")
    public String postMessage(@PathVariable String channelId, @RequestBody String messageInfo) {
        return "Message created in Channel ID: " + channelId + " with info: " + messageInfo;
    }

    // DELETE Mapping to delete a specific message by its ID in a specific channel
    @DeleteMapping("/{messageId}")
    public String deleteMessage(@PathVariable String channelId, @PathVariable String messageId) {
        return "Message with ID " + messageId + " deleted in Channel ID: " + channelId;
    }
}
