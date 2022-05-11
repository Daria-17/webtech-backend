package de.htw.webtechdemo.web.persistence;

import javax.persistence.*;

@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nickname", nullable = false)
    private String nickname;
    @Column(name = "is_acive", nullable = false)
    private boolean active;

    public UserEntity(String nickname, boolean active) {
        this.nickname = nickname;
        this.active = active;
    }

    protected UserEntity(){}
    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
