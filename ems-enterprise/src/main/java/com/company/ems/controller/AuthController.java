package com.company.ems.controller;

import com.company.ems.dto.LoginRequest;
import com.company.ems.dto.SignupRequest;
import com.company.ems.dto.JwtAuthenticationResponse;
import com.company.ems.model.Role;
import com.company.ems.model.RoleName;
import com.company.ems.model.User;
import com.company.ems.repository.RoleRepository;
import com.company.ems.repository.UserRepository;
import com.company.ems.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider tokenProvider;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        loginRequest.getUsername(),
        loginRequest.getPassword()
      )
    );

    String jwt = tokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body("Error: Username is already taken!");
    }

    User user = new User();
    user.setUsername(signUpRequest.getUsername());
    user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    user.setRoles(Collections.singleton(userRole));

    userRepository.save(user);

    return ResponseEntity.ok("User registered successfully!");
  }

}
