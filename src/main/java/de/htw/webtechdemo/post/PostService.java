package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.topic.TopicService;
import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
        return postRepository.findById(postId).orElse(null);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Set<Post> findAllByOrderByCreationDateDesc(){

        return postRepository.findAllByOrderByCreationDateDesc();
    }

    public Set<Post> findByUser(User user) {
        return postRepository.findByUser(user);
    }

    public Set<Post> findByTopic(Topic topic) {
        return postRepository.findByTopic(topic);
    }

    public Set<Post> findByTopic(Long topicId) {
        return postRepository.findByTopic(topicService.findOne(topicId));
    }

    public Post create(PostManipulationRequest request) {
        return null;
    }

    public void delete(Long postId) {

    }

    public void delete(Post post) {

    }
}
