package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.TopicEntity;
import de.htw.webtechdemo.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private TopicEntity topic;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private UserEntity user;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(updatable = false, nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate lastUpdateDate;

    protected PostEntity() {
    }

    public PostEntity(TopicEntity topic, UserEntity user, String content, LocalDate creationDate, LocalDate lastUpdateDate) {
        this.topic = topic;
        this.user = user;
        this.content = content;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    @PrePersist
    protected void onCreate(){
        this.creationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.lastUpdateDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public TopicEntity getTopicEntity() {
        return topic;
    }

    public void setTopicEntity(TopicEntity topic) {
        this.topic = topic;
    }

    public UserEntity getUserEntity() {
        return user;
    }

    public void setUser(UserEntity user) {
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
}
