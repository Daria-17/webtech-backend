package de.htw.webtechdemo.user;

public class UserManipulationRequest {

    private long id;
    private String nickname;
    private int age;
    private String lastname;
    private String name;
    private String aboutMe;
    private Gender gender;
    private boolean active;

    public UserManipulationRequest(Long id, String nickname, int age, Boolean active, String lastname, String name, Gender gender, String aboutMe) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.active = active;
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.aboutMe = aboutMe;
    }

    public UserManipulationRequest() {}

        public Long getId () {
            return id;
        }

        public String getNickname () {
            return nickname;
        }

        public void setNickname (String nickname){
            this.nickname = nickname;
        }

        public int getAge() { return age; }

        public void setAge(int age) { this.age = age; }

        public void setLastname (String lastname){
            this.lastname = lastname;
        }

        public void setName (String name){
            this.name = name;
        }
        public String getLastname () {
            return lastname;
        }

        public String getName () {
            return name;
        }

        public boolean isActive () {
            return active;
        }

        public void setActive (Boolean active){
            this.active = active;
        }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

        public String getAboutMe () {
            return aboutMe;
        }

        public void setAboutMe (String aboutMe){
            this.aboutMe = aboutMe;
        }

    public Boolean getActive() {
        return active;
    }
}
