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

    @Column(name = "(lastname, ", nullable = false)
    private String lastname;
//
    @Column(name = "(name, ", nullable = false)
    private String name;

    @Column
    private int age;

    @Column
    private Gender gender;

    @Column(length = 150)
    private String aboutMe;

    //private Rolle rolle;


    public UserEntity(Long id, String nickname, int age, String name, String lastname, boolean active, Gender gender, String aboutMe) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.active = active;
        this.lastname = lastname;
        this.name = name;
        this.aboutMe = aboutMe;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Gender getGender() {return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }



}

