package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TopicRepository extends JpaRepository <Topic, Long> {


    Set<Topic> findByUser(User user);

    Set<Topic> findAllByOrderByCreationDateDesc();

}
