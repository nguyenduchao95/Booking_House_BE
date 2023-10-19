package com.booking_house_be.controller;

import com.booking_house_be.entity.Message;
import com.booking_house_be.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
public class MessageController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private IMessageService messageService;

    @MessageMapping("/chat")
    public void greeting(Message message) {
        message.setStatus(false);
        message.setCreateAt(LocalDateTime.now());
        Message messageDB = messageService.save(message);
        String destinationReceive = "/topic/" + message.getReceiver().getId();
        simpMessagingTemplate.convertAndSend(destinationReceive, messageDB);
    }

    @GetMapping("/api/messages/{senderId}/{receiverId}")
    public ResponseEntity<?> getAllMessagesBySenderIdAndReceiverId(@PathVariable int senderId,
                                                                   @PathVariable int receiverId) {
        try {
            return ResponseEntity.ok(messageService.findAllBySenderIdAndReceiverId(senderId, receiverId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }

    @GetMapping("/api/messages/count/{receiverId}")
    public int countUnreadMessagesByReceiverId(@PathVariable int receiverId) {
        try {
            return messageService.countUnreadMessagesByReceiverId(receiverId);
        } catch (Exception e) {
            return 0;
        }
    }

    @GetMapping("/api/messages/count/{accountId}/{senderId}")
    public int countUnreadMessagesByAccountLoginIdAndSenderId(@PathVariable int accountId,
                                                              @PathVariable int senderId) {
        try {
            return messageService.countUnreadMessagesByAccountLoginIdAndSenderId(accountId, senderId);
        } catch (Exception e) {
            return 0;
        }
    }

    @GetMapping("/api/messages/change-status/{accountId}/{senderId}")
    public ResponseEntity<?> changeStatusMessage(@PathVariable int accountId, @PathVariable int senderId) {
        try {
            messageService.changeStatusMessage(accountId, senderId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }
}
