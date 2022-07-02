package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.section.SectionEntity;
import de.htw.webtechdemo.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity(name = "topics")
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users")
    @Column(name = "user")
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    @Column(name = "section")
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

    public TopicEntity(UserEntity user, SectionEntity section, String title, String content, LocalDate creationDate, LocalDate lastUpdateDate, boolean active) {
        this.user = user;
        this.section = section;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.active = active;
    }

    protected TopicEntity () {}
}
