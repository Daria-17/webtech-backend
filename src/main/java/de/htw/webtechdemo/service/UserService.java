package de.htw.webtechdemo.service;

import de.htw.webtechdemo.persistence.UserEntity;
import de.htw.webtechdemo.persistence.UserRepository;
import de.htw.webtechdemo.web.api.User;
import de.htw.webtechdemo.web.api.UserManipulationRequest;
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
        return userEntity.map(this::transformEntity).orElse(null);

    }

    public User create(UserManipulationRequest request) {
        var userEntity = new UserEntity(request.getNickname(), request.isActive());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    public User update(Long id, UserManipulationRequest request){
        var userEntityOptional = userRepository.findById(id);
        if(userEntityOptional.isEmpty()){
            return null;
        }
        var userEntity = userEntityOptional.get();
        userEntity.setNickname(request.getNickname());
        userEntity.setActive(request.isActive());
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

    private User transformEntity(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getNickname(),
                userEntity.getActive()
        );
    }
}
