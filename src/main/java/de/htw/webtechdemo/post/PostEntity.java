package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    private Topic topic;
//
////    @ManyToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "id", referencedColumnName = "id")
//    private User user;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(updatable = false, nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate lastUpdateDate;

    public PostEntity() {
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

//    public Topic getTopic() {
//        return topic;
//    }
//
//    public void setTopic(Topic topic) {
//        this.topic = topic;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

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
