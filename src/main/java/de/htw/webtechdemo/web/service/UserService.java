package de.htw.webtechdemo.web.service;

import de.htw.webtechdemo.web.api.User;
import de.htw.webtechdemo.web.persistence.UserEntity;
import de.htw.webtechdemo.web.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getNickname(),
                        userEntity.isActive()
                )).collect(Collectors.toList());
    }
}
