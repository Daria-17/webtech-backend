package de.htw.webtechdemo.web.api;

public class UserManipulationRequest {

    private String nickname;
    private boolean active;

    public UserManipulationRequest(String nickname, boolean active) {
        this.nickname = nickname;
        this.active = active;
    }

    public UserManipulationRequest() {}

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
