package com.disney.alkemy.Auth.Controller;

import com.disney.alkemy.Auth.DTO.AuthenticationRequest;
import com.disney.alkemy.Auth.DTO.AuthenticationResponse;
import com.disney.alkemy.Auth.DTO.UserDTO;
import com.disney.alkemy.Auth.Service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserDetailsCustomService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> signUp(@Valid @RequestBody UserDTO user) throws Exception {
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> signIn(@Valid @RequestBody AuthenticationRequest request) throws Exception {
        AuthenticationResponse response = service.authenticate(request);
        return ResponseEntity.ok(response);

    }

}
