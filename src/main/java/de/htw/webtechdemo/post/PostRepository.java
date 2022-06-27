package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PostRepository extends JpaRepository <PostEntity, Long> {

    Set<PostEntity> findByUser(User user);
    Set<PostEntity> findByTopic(Topic topic);
    Set<PostEntity> findAllByOrderByCreationDateDesc();

}
