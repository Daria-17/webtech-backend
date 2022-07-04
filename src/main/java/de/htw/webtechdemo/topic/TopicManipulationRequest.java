package de.htw.webtechdemo.topic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TopicManipulationRequest {


    private Long userId;
    private String title;
    private String content;
    private LocalDate lastUpdateDate;
    private boolean active;

    public TopicManipulationRequest(Long userId,
                                    String title,
                                    String content,
                                    boolean active) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.lastUpdateDate = LocalDate.now();
        this.active = active;
    }
}
