package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.Section;
import de.htw.webtechdemo.section.SectionEntity;
import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "topics")
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private SectionEntity section;

    @Column(length = 80, name = "title")
    private String title;

    @Column(columnDefinition = "TEXT", name = "content")
    private String content;

    @Column(updatable = false, nullable = false, name = "creationDate")
    private LocalDate creationDate;

    @Column(nullable = false, name = "lastUpdateDate")
    private LocalDate lastUpdateDate;

    @Column(nullable = false, name = "active")
    private boolean active;

    public TopicEntity(UserEntity userEntity, SectionEntity section, String title, String content, LocalDate creationDate, LocalDate lastUpdateDate, boolean active) {
        this.user = user;
        this.section = section;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.active = active;
    }

    protected TopicEntity () {}

    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public SectionEntity getSection() {
        return section;
    }

    public void setSection(SectionEntity section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
