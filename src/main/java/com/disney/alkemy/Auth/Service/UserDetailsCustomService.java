package com.disney.alkemy.Auth.Service;

import com.disney.alkemy.Auth.DTO.AuthenticationRequest;
import com.disney.alkemy.Auth.DTO.AuthenticationResponse;
import com.disney.alkemy.Auth.DTO.UserDTO;
import com.disney.alkemy.Auth.Entity.UserEntity;
import com.disney.alkemy.Auth.Repository.UserRepository;
import com.disney.alkemy.Service.EmailService;
import com.disney.alkemy.Service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Usuario o pasword invalidos");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDTO userDTO) {
        UserEntity user = userRepository.findByUsername(userDTO.getUsername());
        if(user != null) {
            throw new UsernameNotFoundException("El nombre de usuario ya está en uso");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity = userRepository.save(userEntity);
        emailService.sendWelcomeEmailTo(userEntity.getUsername());
        return true;
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception {
        UserDetails userDetails;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new Exception("Nombre de usuario o contraseña incorrecta", e);
        }
        final String jwt = jwtUtils.generateToken(userDetails);
        return new AuthenticationResponse(jwt);
    }

}
