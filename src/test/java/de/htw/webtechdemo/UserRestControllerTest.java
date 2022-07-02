package de.htw.webtechdemo;
import java.util.*;

import de.htw.webtechdemo.user.Gender;
import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;

public class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("should return found users from user service")
    void should_return_found_users_from_user_service(){
        var users = List.of(
                new User(1L, "lady", 17, true, "Scholz", "Diana", Gender.MALE,
                        "Hey! Ich bin Diana und suche hier Freunde")
        );
        doReturn(users).when(userService).findAll();

        //mockMvc.perform(getClass("/api/v1/users")).andExpect(status())
    }


}
