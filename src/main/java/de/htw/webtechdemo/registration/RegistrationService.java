package de.htw.webtechdemo.registration;

import de.htw.webtechdemo.registration.token.ConfirmationToken;
import de.htw.webtechdemo.registration.token.ConfirmationTokenService;
import de.htw.webtechdemo.user.User;
import de.htw.webtechdemo.user.UserRole;
import de.htw.webtechdemo.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private UserService userService;
    private EmailValidator emailValidator;
    private ConfirmationTokenService confirmationTokenService;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email is not valid.");
        }

        return userService.singUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token).orElseThrow(
                () -> new IllegalStateException("Token not found.")
        );
        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Email is already confirmed.");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token is expired.");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getEmail()
        );

        return "confirmed";
    }


}

