package de.htw.webtechdemo.web.service;

import de.htw.webtechdemo.web.api.User;
import de.htw.webtechdemo.web.api.UserCreateRequest;
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
                .map(this::transformEntity).collect(Collectors.toList());
    }

    public User findById(Long id){
        var userEntity = userRepository.findById(id);
        return userEntity.isPresent()? transformEntity(userEntity.get()) : null;


    }

    public User create(UserCreateRequest request) {
        var userEntity = new UserEntity(request.getNickname(), request.isActive());
        userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    private User transformEntity(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getNickname(),
                userEntity.isActive()
        );
    }
}
