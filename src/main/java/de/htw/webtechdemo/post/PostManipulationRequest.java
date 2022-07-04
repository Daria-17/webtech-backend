package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PostManipulationRequest {

    private Topic topic;
    private User user;
    private String content;
    private LocalDate lastUpdateDate;

    public PostManipulationRequest(Topic topic, User user, String content) {
        this.topic = topic;
        this.user = user;
        this.content = content;
        this.lastUpdateDate = LocalDate.now();
    }
}
