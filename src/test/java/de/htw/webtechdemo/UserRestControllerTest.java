package de.htw.webtechdemo;

import de.htw.webtechdemo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

public class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

//    @Test
//    @DisplayName("should return found users from user service")
//    void should_return_found_users_from_user_service(){
//        var users = List.of(
//                new User(1L, "lady", 17, true, "Scholz", "Diana", Gender.MALE,
//                        "Hey! Ich bin Diana und suche hier Freunde")
//        );
//        doReturn(users).when(userService).findAll();
//
//        //mockMvc.perform(getClass("/api/v1/users")).andExpect(status())
//    }


}
