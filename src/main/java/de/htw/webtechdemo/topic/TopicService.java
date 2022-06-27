package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.SectionService;
import de.htw.webtechdemo.user.User;
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
        Set<Topic> topics = topicRepository.findBySection(sectionService.findByName(sectionName));
        return topics;
    }

    public Topic save(TopicManipulationRequest request) {
        var topicEntity = new TopicEntity(
                request.getUser(),
                request.getSection(),
                request.getTitle(),
                request.getContent(),
                request.getCreationDate(),
                request.getLastUpdateDate(),
                request.isActive());
        topicEntity = topicRepository.save(topicEntity);
        return transformEntity(topicEntity);
    }

    public Set<Topic> findBySection(Long id) {
        Set<Topic> topics = topicRepository.findBySection(sectionService.findOne(id));
        return topics;
    }

    public Set<Topic> findByUser(User user) {
        Set<Topic> topics = topicRepository.findByUser(user);
        return topics;
    }

    public void delete(Long id) {
        delete(findOne(id));
    }
    public void delete(Topic topic) {
        topicRepository.delete(topic);
    }

    private Topic transformEntity(TopicEntity topicEntity){
        return new Topic(
                topicEntity.getUser(),
                topicEntity.getSection(),
                topicEntity.getTitle(),
                topicEntity.getContent(),
                topicEntity.getCreationDate(),
                topicEntity.getLastUpdateDate(),
                topicEntity.isActive());
    }
}
