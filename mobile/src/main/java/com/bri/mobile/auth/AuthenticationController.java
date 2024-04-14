package com.bri.mobile.auth;

import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.mail.EmailService;
import com.bri.mobile.tool.authRequest.AuthenticationRequest;
import com.bri.mobile.tool.mail.EmailDetails;
import com.bri.mobile.tool.authRequest.RegisterRequest;
import com.bri.mobile.tool.mail.Success;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @Autowired
    private EmailService emailService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));

    }
    @GetMapping("/userDetails")
    public ResponseEntity<UserDto>getUser(@RequestHeader(name = "Authorization") String token){
        return ResponseEntity.ok(authenticationService.getUserDetails(token));
    }
    @PostMapping("/password")
    public Success setPassword(@RequestBody EmailDetails email)  {
        return emailService.sendHtmlEmail(email);
    }
}
