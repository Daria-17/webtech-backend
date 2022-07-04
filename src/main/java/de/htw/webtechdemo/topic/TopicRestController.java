package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.post.NewPostForm;
import de.htw.webtechdemo.post.Post;
import de.htw.webtechdemo.post.PostService;
import de.htw.webtechdemo.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/topics")
@AllArgsConstructor
public class TopicRestController {

    private final TopicService topicService;
    private final PostService postService;
    private final UserService userService;

    @GetMapping
    public Page<Topic> list(@PageableDefault(sort = "id",
            direction = Sort.Direction.ASC
    )
                            Pageable pagination
    ) {
        return topicService.findAll(pagination);
    }
    @GetMapping(path = "{id}")
    public Topic findById(@PathVariable() Long id) {
        return topicService.findOne(id);
    }
/*
    @PostMapping
    @Transactional
    public ResponseEntity<Topic> create(@RequestBody TopicManipulationRequest request, UriComponentsBuilder uriBuilder) {
        Topic topic = topicService.create(request).orElse(null);
        assert topic != null;
        URI uri = uriBuilder.path("/api/v1/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(topic);
    }*/

    @RequestMapping(value = "{idTopic}", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("newPost") NewPostForm newPost,
                          BindingResult result,
                          @PathVariable Long idTopic,
                          Model model) {

        if (result.hasErrors()) {
            model.addAttribute("topic", topicService.findOne(idTopic));
            model.addAttribute("posts", postService.findByTopic(idTopic));
            return "topic";
        }

        Post post = new Post();
        post.setContent(newPost.getContent());
        post.setTopic(topicService.findOne(idTopic));
        post.setUser(userService.findById(1L));
        postService.save(post);

        model.asMap().clear();
        return "redirect:/topic/" + idTopic;
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Topic> update(@PathVariable() Long id, @RequestBody TopicManipulationRequest request) {
        Topic topic = topicService.update(id, request).orElse(null);
        return ResponseEntity.ok(topic);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean successful = topicService.delete(id);
        return successful? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }

}
