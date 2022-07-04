package de.htw.webtechdemo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserManipulationRequest {

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String username;
    private String email;
    private String password;
    private UserRole userRole;
    private LocalDate creationDate;
    private Boolean locked;
    private Boolean enabled;


}
