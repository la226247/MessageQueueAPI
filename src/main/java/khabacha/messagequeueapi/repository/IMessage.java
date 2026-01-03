package khabacha.messagequeueapi.repository;

// Interface for content operations
// Using JPA and LOMBOK for database interactions and boilerplate code reduction

import khabacha.messagequeueapi.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessage extends JpaRepository<Message, Long> {


}
