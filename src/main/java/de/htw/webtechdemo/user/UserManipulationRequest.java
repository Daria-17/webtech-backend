package de.htw.webtechdemo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserManipulationRequest {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String username;
    private String email;
    private String password;
    private UserRole userRole;
    private LocalDate creationDate;
    private boolean active;
    private Boolean locked;
    private Boolean enabled;


}
