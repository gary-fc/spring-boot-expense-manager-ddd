package com.garyfrancodev.ExpenseManagerInfrastructure.services;

import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerDomain.services.AuthService;
import com.garyfrancodev.ExpenseManagerInfrastructure.jwt.JwtService;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user.UserJpaRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserJpaRepository userRepository;

    @Override
    public ResponseEntity<Map<String, String>> login(String email, String password) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        Optional<UserJpaModel> userDetails = userRepository.findByEmail(email);
        Map<String, String> body = new HashMap<>();

        if (userDetails.isPresent()) {
            User user = new User(userDetails.get().getFirstName(), userDetails.get().getLastName(), userDetails.get().getEmail(), userDetails.get().getPassword(), userDetails.get().getId());
            body.put("jwt", jwtService.getToken(user));
            body.put("userId", userDetails.get().getId().toString());

            return ResponseEntity.ok(body);
        }

        body.put("error", "User not found");

        return ResponseEntity.status(403).body(body);
    }

    @Override
    public ResponseEntity<String> register(User user) {
        UserJpaModel userJpaModel = UserUtils.mapToJpaEntity(user);
        userJpaModel.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userJpaModel);

        return ResponseEntity.ok(jwtService.getToken(user));
    }
}
