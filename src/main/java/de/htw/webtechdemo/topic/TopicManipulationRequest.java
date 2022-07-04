package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TopicManipulationRequest {

    private User user;
    private String title;
    private String content;
    private LocalDate lastUpdateDate;
    private boolean active;

    public TopicManipulationRequest(User user,
                                    String title,
                                    String content,
                                    boolean active) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.lastUpdateDate = LocalDate.now();
        this.active = active;
    }
}
