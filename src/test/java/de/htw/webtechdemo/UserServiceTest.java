package de.htw.webtechdemo;

import de.htw.webtechdemo.user.UserRepository;
import de.htw.webtechdemo.user.UserService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest implements WithAssertions {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        Long givenId = 125L;
        doReturn(true).when(repository).existsById(givenId);
        boolean result = underTest.deleteById(givenId);
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if user to delete doesn't exist")
    void should_return_false_if_user_to_delete_does_not_exist() {
        Long givenId = 125L;
        doReturn(false).when(repository).existsById(givenId);
        boolean result = underTest.deleteById(givenId);
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }

//    @Test
//    @DisplayName("should transform user to User")
//    void should_transform_user_to_User() {
//        var user = Mockito.mock(User.class);
//        doReturn(1L).when(user).getId();
//        doReturn("Diana").when(user).getFirstName();
//        doReturn("Scholz").when(user).getLastName();
//        doReturn(LocalDate.of(2002, 5, 6)).when(user).getDob();
//        doReturn("diana_scholz_08_12@gmail.com").when(user).getEmail();
//        doReturn("0812200621").when(user).getPassword();
//        doReturn(UserRole.USER).when(user).getUserRole();
//      doReturn(LocalDate.of(2020, 5, 7)).when(user).getCreationDate();
//        doReturn(true).when(user).getLocked();
//        doReturn(true).when(user).getEnabled();
//
//
//        var result = underTest.transformEntity(user);
//
//        assertThat(result.getId()).isEqualTo(1L);
//        assertThat(result.getFirstName()).isEqualTo("Diana");
//        assertThat(result.getLastName()).isEqualTo("Scholz");
//        assertThat(result.getDob()).isEqualTo(LocalDate.of(2002, 5, 6));
//        assertThat(result.getEmail()).isEqualTo("diana_scholz_08_12@gmail.com");
//        assertThat(result.getPassword()).isEqualTo("0812200621");
//        assertThat(result.getUserRole()).isEqualTo(UserRole.USER);
//        assertThat(result.getCreationDate()).isEqualTo(LocalDate.of(2020, 5, 7));
//        assertThat(result.getLocked()).isEqualTo(true);
//        assertThat(result.getEnabled()).isEqualTo(true);
//
//    }
}




