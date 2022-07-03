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

}




