package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.Section;
import de.htw.webtechdemo.user.User;

import java.time.LocalDate;

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
                                    LocalDate creationDate,
                                    LocalDate lastUpdateDate,
                                    boolean active) {
        this.user = user;
        this.section = section;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.active = active;
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
