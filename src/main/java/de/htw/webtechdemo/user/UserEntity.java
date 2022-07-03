package de.htw.webtechdemo.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "users")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private LocalDate creationDate;
    private boolean active;
    private Boolean locked;
    private Boolean enabled;

    public UserEntity(String firstName, String lastName, LocalDate dob, String username, String email, String password,
                      UserRole userRole, LocalDate creationDate, boolean active, Boolean locked, Boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.creationDate = creationDate;
        this.active = active;
        this.locked = locked;
        this.enabled = enabled;
    }
}

