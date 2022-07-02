package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.topic.TopicEntity;
import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserEntity;

import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private Long id;
    private Topic topic;
    private User user;
    private String content;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;

    public Post(Long id, Topic topic, User user, String content, LocalDate creationDate, LocalDate lastUpdateDate) {
        this.id = id;
        this.topic = topic;
        this.user = user;
        this.content = content;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Post() {
    }

    protected void onCreate(){
        this.creationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
    }

    protected void onUpdate(){
        this.lastUpdateDate = LocalDate.now();
    }

    public Long getId() {
        return id;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(topic, post.topic) && Objects.equals(user, post.user) && Objects.equals(content, post.content) && Objects.equals(creationDate, post.creationDate) && Objects.equals(lastUpdateDate, post.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, user, content, creationDate, lastUpdateDate);
    }
}
