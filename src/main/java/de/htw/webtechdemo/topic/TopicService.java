package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.SectionRepository;
import de.htw.webtechdemo.section.SectionService;
import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserRepository;
import de.htw.webtechdemo.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class TopicService {

    private final TopicRepository topicRepository;

    private final SectionService sectionService;

    private final SectionRepository sectionRepository;

    private final UserService userService;

    private final UserRepository userRepository;



    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Topic findOne(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    public Set<Topic> findAllByOrderByCreationDateDesc() {
        return topicRepository.findAllByOrderByCreationDateDesc();
    }

    public Set<Topic> findBySection(String sectionName) {
        return topicRepository.findBySection(sectionRepository.getById(sectionRepository.findByName(sectionName).getId()));
    }

    public Topic save(TopicManipulationRequest request) {

        var topic = new Topic(
                userRepository.getById(request.getUser().getId()),
                sectionRepository.getById(request.getSection().getId()),
                request.getTitle(),
                request.getContent(),
                request.getCreationDate(),
                request.getLastUpdateDate(),
                request.isActive());
        topic = topicRepository.save(topic);
        return topic;
    }

    public Set<Topic> findBySection(Long id) {
        return topicRepository.findBySection(sectionRepository.getById(id));
    }

    public Set<Topic> findByUser(User user) {
        return topicRepository.findByUser(userRepository.getById(user.getId()));
    }

    public void delete(Long id) {
        topicRepository.delete(topicRepository.getById(id));
    }
    public void delete(Topic topic) {
        topicRepository.delete(topic);
    }

}
