package khabacha.messagequeueapi.services;

import khabacha.messagequeueapi.models.Message;
import khabacha.messagequeueapi.repository.IMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private IMessage messageRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishMessage(String content) {
        rabbitTemplate.convertAndSend("messages", content);
        
        Message message = new Message();
        message.setContent(content);
        messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}