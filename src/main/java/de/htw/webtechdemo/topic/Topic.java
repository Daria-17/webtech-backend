package de.htw.webtechdemo.topic;

import de.htw.webtechdemo.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    @Column(length = 80)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(updatable = false, nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate lastUpdateDate;

    @Column(nullable = false)
    private boolean active;

    public Topic(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.creationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
        this.active = true;
    }

    protected Topic() {}
}
