package de.htw.webtechdemo.web.api;

public class UserCreateRequest {

    private String nickname;
    private boolean active;

    public UserCreateRequest(String nickname, boolean active) {
        this.nickname = nickname;
        this.active = active;
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
