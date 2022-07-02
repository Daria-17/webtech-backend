package de.htw.webtechdemo;

import de.htw.webtechdemo.user.Gender;
import de.htw.webtechdemo.user.UserEntity;
import de.htw.webtechdemo.user.UserRepository;
import de.htw.webtechdemo.user.UserService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
        doReturn("lady").when(UserEntity).getNickname();
        doReturn(17).when(UserEntity).getAge();
        doReturn(true).when(UserEntity).isActive();
        doReturn("Scholz").when(UserEntity).getLastname();
        doReturn("Diana").when(UserEntity).getName();
        doReturn(Gender.MALE).when(UserEntity).getGender();
        doReturn("Hey! Ich bin Diana und suche hier Freunde!").when(UserEntity).getAboutMe();


        var result = underTest.transformEntity(UserEntity);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getNickname()).isEqualTo("lady");
        assertThat(result.getAge()).isEqualTo(17);
        assertThat(result.isActive()).isEqualTo(true);
        assertThat(result.getLastname()).isEqualTo("Scholz");
        assertThat(result.getName()).isEqualTo("Diana");
        assertThat(result.getGender()).isEqualTo(Gender.MALE);
        assertThat(result.getAboutMe()).isEqualTo("Hey! Ich bin Diana und suche hier Freunde!");

    }
}




