package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.topic.TopicService;
import de.htw.webtechdemo.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private  final TopicService topicService;

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

    public Optional<Post> create(PostManipulationRequest request) {
        Post post = new Post(
                request.getTopic(),
                request.getUser(),
                request.getContent());
        postRepository.save(post);
        return postRepository.findById(post.getId());
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }
}
