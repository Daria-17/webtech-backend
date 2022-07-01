package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.topic.TopicService;
import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post findOne(Long postId) {
        var postEntity = postRepository.findById(postId);
        return postEntity.map(this::transformEntity).orElse(null);
    }

    public List<Post> findAll() {
        List<PostEntity> posts = postRepository.findAll();
        return posts.stream()
                .map(this::transformEntity).collect(Collectors.toList());
    }

    public Set<Post> findAllByOrderByCreationDateDesc(){
        Set<PostEntity> posts = postRepository.findAllByOrderByCreationDateDesc();

        return posts.stream()
                .map(this::transformEntity).collect(Collectors.toSet());
    }

    public Set<Post> findByUser(User user) {
        Set<PostEntity> posts = postRepository.findByUser(user);
        return posts.stream()
                .map(this::transformEntity).collect(Collectors.toSet());
    }

    public Set<Post> findByTopic(Topic topic) {
        Set<PostEntity> posts = postRepository.findByTopic(topic);
        return posts.stream()
                .map(this::transformEntity).collect(Collectors.toSet());
    }

    public Set<Post> findByTopic(Long topicId) {
        Set<PostEntity> posts = postRepository.findByTopic(topicService.findOne(topicId));
        return posts.stream()
                .map(this::transformEntity).collect(Collectors.toSet());
    }

    public Post create(PostManipulationRequest request) {
        return null;
    }

    public void delete(Long postId) {

    }

    public void delete(Post post) {

    }

    private Post transformEntity(PostEntity postEntity){
        return new Post(
                postEntity.getId(),
                postEntity.getTopicEntity(),
                postEntity.getUserEntity(),
                postEntity.getContent(),
                postEntity.getCreationDate(),
                postEntity.getLastUpdateDate());
    }


}
