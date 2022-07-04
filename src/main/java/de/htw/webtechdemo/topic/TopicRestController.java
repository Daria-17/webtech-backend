package de.htw.webtechdemo.topic;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/topics")
@AllArgsConstructor
public class TopicRestController {

    private final TopicService topicService;

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

    @PostMapping
    @Transactional
    public ResponseEntity<Topic> create(@RequestBody TopicManipulationRequest request, UriComponentsBuilder uriBuilder) {
        Topic topic = topicService.create(request).orElse(null);
        assert topic != null;
        URI uri = uriBuilder.path("/api/v1/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(topic);
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
