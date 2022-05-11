package de.htw.webtechdemo.web.api;

public class User {

    private Long id;
    private String nickname;
    private boolean active;

    public User(Long id, String nickname, boolean active) {
        this.id = id;
        this.nickname = nickname;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


