package com.company.ems.service;

import com.company.ems.model.User;
import com.company.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User saveUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public User updateUser(Long id, User userDetails) {
    Optional<User> userOpt = userRepository.findById(id);
    if (userOpt.isPresent()) {
      User user = userOpt.get();
      user.setUsername(userDetails.getUsername());
      if (userDetails.getPassword() != null) {
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
      }
      user.setRoles(userDetails.getRoles());
      return userRepository.save(user);
    }
    return null;
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
