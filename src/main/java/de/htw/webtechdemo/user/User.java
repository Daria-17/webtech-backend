package de.htw.webtechdemo.user;

public class User {

    private long id;
    private String nickname;
    private String lastname;
    private String name;
    private String aboutMe;
    private boolean active;

    public User(Long id, String nickname, int age, Boolean active, String lastname, String name, String aboutMe) {
        this.nickname = nickname;
        this.active = active;
        this.lastname = lastname;
        this.name = name;
        this.aboutMe = aboutMe;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



}


