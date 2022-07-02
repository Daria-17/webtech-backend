package de.htw.webtechdemo.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found.";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public List<User> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(this::transformEntity).collect(Collectors.toList());
    }

    public User findById(Long id){
        var userEntity = userRepository.findById(id);
        return userEntity.map(this::transformEntity).orElse(null);

    }

    public User create(UserManipulationRequest request) {
        var userEntity = new UserEntity(
                request.getFirstName(),
                request.getLastName(),
                request.getDob(),
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getUserRole(),
                request.getCreationDate(),
                request.isActive(),
                request.getLocked(),
                request.getEnabled()
                );
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    public User update(Long id, UserManipulationRequest request){
        var userEntityOptional = userRepository.findById(id);
        if(userEntityOptional.isEmpty()){
            return null;
        }
        var userEntity = userEntityOptional.get();
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setDob(request.getDob());
        userEntity.setUsername(request.getUsername());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());
        userEntity.setUserRole(request.getUserRole());
        userEntity.setActive(request.isActive());
        userEntity.setLocked(request.getLocked());
        userEntity.setEnabled(request.getEnabled());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);

    }
    public boolean deleteById (Long id){
        if(!userRepository.existsById(id)){
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    public User transformEntity(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getDob(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getUserRole(),
                userEntity.getCreationDate(),
                userEntity.isActive(),
                userEntity.getLocked(),
                userEntity.getEnabled()
        );
    }


}
