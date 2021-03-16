package com.example.pract.services.impl;

import com.example.pract.dao.UserRepository;
import com.example.pract.models.User;
import com.example.pract.services.IUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUser {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public User update(int id, String name, int age) {
        User instance = userRepository.getOne(id);
        instance.setName(name);
        instance.setAge(age);
        return userRepository.save(instance);

    }

    @Override
    public User getById(int id) {
        Optional<User> candidate = userRepository.findById(id);
        return candidate.orElse(null);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
