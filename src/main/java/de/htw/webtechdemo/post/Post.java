package de.htw.webtechdemo.post;

import de.htw.webtechdemo.topic.Topic;
import de.htw.webtechdemo.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Topic topic;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(updatable = false, nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate lastUpdateDate;

    public Post(Topic topic, User user, String content) {
        this.topic = topic;
        this.user = user;
        this.content = content;
        this.creationDate = LocalDate.now();
        this.lastUpdateDate = LocalDate.now();
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
