package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.Section;
import de.htw.webtechdemo.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TopicManipulationRequest {

    private User user;
    private Section section;
    private String title;
    private String content;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private boolean active;

    public TopicManipulationRequest(User user,
                                    Section section,
                                    String title,
                                    String content,
                                    LocalDate lastUpdateDate,
                                    boolean active) {
        this.user = user;
        this.section = section;
        this.title = title;
        this.content = content;
        this.creationDate = LocalDate.now();
        this.lastUpdateDate = lastUpdateDate;
        this.active = active;
    }
}
