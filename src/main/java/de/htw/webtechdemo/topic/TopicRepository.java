package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.Section;
import de.htw.webtechdemo.section.SectionEntity;
import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TopicRepository extends JpaRepository <TopicEntity, Long> {

    Set<Topic> findBySection(SectionEntity section);

    Set<Topic> findByUser(UserEntity user);

    Set<Topic> findAllByOrderByCreationDateDesc();

}
