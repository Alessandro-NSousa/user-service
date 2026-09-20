package com.user.service.service;

import com.user.service.model.User;
import com.user.service.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public User update(Integer id, User data) {
       var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

       if (data.getName() != null)
        user.setName(data.getName());
       if (data.getEmail() != null)
        user.setEmail(data.getEmail());

       return userRepository.save(user);
    }

    @Transactional
    public void delete(Integer id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.deleteById(id);
    }
}
