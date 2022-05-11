package de.htw.webtechdemo.web;

import de.htw.webtechdemo.web.api.User;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    private List<User> users;

    public UserRestController(){
        users = new ArrayList<>();
        users.add(new User(1, "ZeroFiveOne", true));
        users.add(new User(2, "JuliasCeasarOnlyOne", true));
    }

    @GetMapping(path = "/api/v1/users")
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> fetchUsers() {
        return users;
    }
}
