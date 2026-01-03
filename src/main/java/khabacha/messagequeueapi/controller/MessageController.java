package khabacha.messagequeueapi.controller;

import khabacha.messagequeueapi.models.Message;
import khabacha.messagequeueapi.services.JwtService;
import khabacha.messagequeueapi.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/publish")
    public ResponseEntity<?> publishMessage(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody Message message) {

        try {
            String token = authHeader.replace("Bearer ", "");

            if (!jwtService.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid or expired token");
            }

            messageService.publishMessage(message.getContent());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Message published successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Authentication required");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllMessages(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer ", "");

            if (!jwtService.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid or expired token");
            }

            List<Message> messages = messageService.getAllMessages();
            return ResponseEntity.ok(messages);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Authentication required");
        }
    }
}
