package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserRepository;
import de.htw.webtechdemo.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public Page<Topic> findAll(Pageable pagination) {

        return topicRepository.findAll(pagination);
    }

    public Topic findOne(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    public Set<Topic> findAllByOrderByCreationDateDesc() {
        return topicRepository.findAllByOrderByCreationDateDesc();
    }


    public Topic save(TopicManipulationRequest request) {
        var topic = new Topic(
                userRepository.getById(request.getUser().getId()),
                request.getTitle(),
                request.getContent());
        topic = topicRepository.save(topic);
        return topic;
    }

    public Set<Topic> findByUser(User user) {
        return topicRepository.findByUser(userRepository.getById(user.getId()));
    }

    public boolean delete(Long id) {
        if(!topicRepository.existsById(id)){
            return false;
        }
        topicRepository.deleteById(id);
        return true;
    }
    public void delete(Topic topic) {
        topicRepository.delete(topic);
    }

    public Optional<Topic> create(TopicManipulationRequest request) {
        Topic topic = new Topic(
                request.getUser(),
                request.getTitle(),
                request.getContent()
        );
        topicRepository.save(topic);
        return topicRepository.findById(topic.getId());
    }

    public Optional<Topic> update(Long id, TopicManipulationRequest request) {
        Topic topic = topicRepository.getById(id);
        topic.setActive(request.isActive());
        topic.setLastUpdateDate(LocalDate.now());
        topic.setTitle(request.getTitle());
        topic.setContent(request.getContent());
        topic.setUser(request.getUser());
        topicRepository.save(topic);
        return topicRepository.findById(id);
    }
}
