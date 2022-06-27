package de.htw.webtechdemo.user;

import javax.persistence.*;

@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public UserEntity(String nickname, Boolean active) {
        this.nickname = nickname;
        this.active = active;
    }

    protected UserEntity(){}

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

