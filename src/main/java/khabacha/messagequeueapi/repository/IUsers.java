package khabacha.messagequeueapi.repository;

import khabacha.messagequeueapi.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsers extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);


}
