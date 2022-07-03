package de.htw.webtechdemo.user;

import de.htw.webtechdemo.registration.token.ConfirmationToken;
import de.htw.webtechdemo.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found.";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String singUpUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail())
                .isPresent();
        if (userExists) {
            throw new IllegalStateException("Email is already taken.");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);


        String token = UUID.randomUUID().toString();
        // TODO: Send Confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        // TODO: Send Email

        return token;
    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);

    }

    public User create(UserManipulationRequest request) {
        var user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                request.getUserRole()
                );
        userRepository.save(user);
        return user;
    }

    public User update(Long id, UserManipulationRequest request){
        var userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            return null;
        }
        var user = userOptional.get();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUserRole(request.getUserRole());
        user.setLocked(request.getLocked());
        user.setEnabled(request.getEnabled());
        user= userRepository.save(user);
        return user;

    }
    public boolean deleteById (Long id){
        if(!userRepository.existsById(id)){
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
