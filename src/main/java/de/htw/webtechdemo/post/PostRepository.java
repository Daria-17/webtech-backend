package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PostRepository extends JpaRepository <Post, Long> {

    Set<Post> findByUser(User user);
    Set<Post> findByTopic(Topic topic);
    Set<Post> findAllByOrderByCreationDateDesc();

}
