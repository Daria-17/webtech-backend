package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.user.User;

import java.time.LocalDate;

public class PostManipulationRequest {

    private Topic topic;
    private User user;
    private String content;
    private LocalDate lastUpdateDate;

    public PostManipulationRequest(Topic topic,
                                   User user,
                                   String content,
                                   LocalDate lastUpdateDate) {
        this.topic = topic;
        this.user = user;
        this.content = content;
        this.lastUpdateDate = lastUpdateDate;
    }

    public PostManipulationRequest() {
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
