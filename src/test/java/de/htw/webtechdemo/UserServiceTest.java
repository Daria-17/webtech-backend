package de.htw.webtechdemo;

import de.htw.webtechdemo.user.*;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


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
    @DisplayName("should return false if user to delete does not exist")
    void should_return_false_if_user_to_delete_does_not_exist() {
        Long givenId = 125L;
        doReturn(false).when(repository).existsById(givenId);
        boolean result = underTest.deleteById(givenId);
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("should transform UserEntity to User")
    void should_transform_UserEntity_to_User() {
        var UserEntity = Mockito.mock(UserEntity.class);
        doReturn(1L).when(UserEntity).getId();
        doReturn("Diana").when(UserEntity).getFirstName();
        doReturn("Scholz").when(UserEntity).getLastName();
        doReturn(LocalDate.of(2002, 5, 6)).when(UserEntity).getDob();
        doReturn("lady").when(UserEntity).getUsername();
        doReturn("diana_scholz_08_12@gmail.com").when(UserEntity).getEmail();
        doReturn("0812200621").when(UserEntity).getPassword();
        doReturn(UserRole.USER).when(UserEntity).getUserRole();
      doReturn(LocalDate.of(2020, 5, 7)).when(UserEntity).getCreationDate();
        doReturn(true).when(UserEntity).isActive();
        doReturn(true).when(UserEntity).getLocked();
        doReturn(true).when(UserEntity).getEnabled();


        var result = underTest.transformEntity(UserEntity);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getFirstName()).isEqualTo("Diana");
        assertThat(result.getLastName()).isEqualTo("Scholz");
       assertThat(result.getDob()).isEqualTo(LocalDate.of(2002, 5, 6));
        assertThat(result.getUsername()).isEqualTo("lady");
        assertThat(result.getEmail()).isEqualTo("diana_scholz_08_12@gmail.com");
        assertThat(result.getPassword()).isEqualTo("0812200621");
        assertThat(result.getUserRole()).isEqualTo(UserRole.USER);
        assertThat(result.getCreationDate()).isEqualTo(LocalDate.of(2020, 5, 7));
        assertThat(result.isActive()).isEqualTo(true);
        assertThat(result.getLocked()).isEqualTo(true);
        assertThat(result.getEnabled()).isEqualTo(true);




    }
}




