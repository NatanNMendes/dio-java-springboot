package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return (User) userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This User ID already exists.");
        }
        return null;
    }

//    @Override
//    public User create(User userToCreate) {
//        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
//            throw new IllegalArgumentException("Account number already exists.");
//        }
//        return userRepository.save(userToCreate);
//    }


}
