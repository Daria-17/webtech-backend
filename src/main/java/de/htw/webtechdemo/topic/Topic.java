package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.Section;
import de.htw.webtechdemo.user.User;

import java.time.LocalDate;
import java.util.Objects;

public class Topic {

    private Long id;
    private User user;
    private Section section;
    private String title;
    private String content;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private boolean active;

    public Topic(User user, Section section, String title, String content, LocalDate creationDate, LocalDate lastUpdateDate, boolean active) {
        this.user = user;
        this.section = section;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.active = active;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return active == topic.active && id.equals(topic.id) && user.equals(topic.user) && section.equals(topic.section) && title.equals(topic.title) && content.equals(topic.content) && creationDate.equals(topic.creationDate) && lastUpdateDate.equals(topic.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, section, title, content, creationDate, lastUpdateDate, active);
    }
}
