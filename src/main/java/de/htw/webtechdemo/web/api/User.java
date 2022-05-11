package de.htw.webtechdemo.web.api;

public class User {

    private long id;
    private String nickname;
    private boolean active;

    public User(Long id, String nickname, boolean active) {
        this.id = id;
        this.nickname = nickname;
        this.active = active;
    }

    protected User(){}

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


