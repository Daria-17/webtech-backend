package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.SectionRepository;
import de.htw.webtechdemo.section.SectionService;
import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserRepository;
import de.htw.webtechdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> findAll() {
        List<TopicEntity> topics = topicRepository.findAll();
        return topics.stream()
                .map(this::transformEntity).collect(Collectors.toList());
    }

    public Topic findOne(Long id) {
        var topicEntity = topicRepository.findById(id);
        return topicEntity.map(this::transformEntity).orElse(null);
    }

    public Set<Topic> findAllByOrderByCreationDateDesc() {
        Set<Topic> topics = topicRepository.findAllByOrderByCreationDateDesc();
        return topics;
    }

    public Set<Topic> findBySection(String sectionName) {
        Set<Topic> topics = topicRepository.findBySection(sectionRepository.getById(sectionRepository.findByName(sectionName).getId()));
        return topics;
    }

    public Topic save(TopicManipulationRequest request) {


        var topicEntity = new TopicEntity(
                userRepository.getById(request.getUser().getId()),
                sectionRepository.getById(request.getSection().getId()),
                request.getTitle(),
                request.getContent(),
                request.getCreationDate(),
                request.getLastUpdateDate(),
                request.isActive());
        topicEntity = topicRepository.save(topicEntity);
        return transformEntity(topicEntity);
    }

    public Set<Topic> findBySection(Long id) {
        Set<Topic> topics = topicRepository.findBySection(sectionRepository.getById(id));
        return topics;
    }

    public Set<Topic> findByUser(User user) {
        Set<Topic> topics = topicRepository.findByUser(userRepository.getById(user.getId()));
        return topics;
    }

    public void delete(Long id) {
        topicRepository.delete(topicRepository.getById(id));
    }
    public void delete(TopicEntity topic) {
        topicRepository.delete(topic);
    }

    public Topic transformEntity(TopicEntity topicEntity){
        return new Topic(
                topicEntity.getId(),
                userService.transformEntity(topicEntity.getUser()),
                sectionService.transformEntity(topicEntity.getSection()),
                topicEntity.getTitle(),
                topicEntity.getContent(),
                topicEntity.getCreationDate(),
                topicEntity.getLastUpdateDate(),
                topicEntity.isActive());
    }
}