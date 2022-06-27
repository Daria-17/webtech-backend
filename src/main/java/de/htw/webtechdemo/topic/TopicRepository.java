package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.Section;
import de.htw.webtechdemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TopicRepository extends JpaRepository <TopicEntity, Long> {

    Set<Topic> findBySection(Section section);

    Set<Topic> findByUser(User user);

    Set<Topic> findAllByOrderByCreationDateDesc();

    void delete(Topic topic);

}
