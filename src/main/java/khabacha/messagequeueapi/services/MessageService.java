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

    // Publier vers RabbitMQ + sauvegarder en BDD
    public void publishMessage(String content) {
        // Envoyer vers RabbitMQ queue "messages"
        // Sauvegarder en BDD
    }

    // Récupérer tous les messages
    public List<Message> getAllMessages() {
        // À compléter
    }
}