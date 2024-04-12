package com.bri.mobile.auth;

import com.bri.mobile.DTO.Mapper.UserMap;
import com.bri.mobile.DTO.model.UserDto;
import com.bri.mobile.Entity.User;
import com.bri.mobile.Enum.StateUser;
import com.bri.mobile.Enum.TokenType;
import com.bri.mobile.Repo.UserRepo;
import com.bri.mobile.config.JwtService;
import com.bri.mobile.tool.authRequest.AuthenticationRequest;
import com.bri.mobile.tool.authRequest.RegisterRequest;
import com.bri.mobile.tool.token.Token;
import com.bri.mobile.tool.token.TokenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepo tokenRepo;
    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .dob(request.getDob())
                .stateUser(request.getStateUser())
                .img(request.getImg())
                .number(request.getNumber())
                .adress(request.getAdress())
                .role(request.getRole())
                .build();
        userRepo.save(user);
        String jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).idRole(user.getRole().getIdRole()).build();
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token
                .builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepo.save(token);
    }
    private void revokeAllUserTokens(User user){
        List<Token> validUserTokens = tokenRepo.findAllValidTokenByUser(user.getIdUtilisateur());
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepo.saveAll(validUserTokens);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        User user = userRepo.findByEmail(request.getEmail()).orElseThrow();
        if (user.getStateUser()== StateUser.Active) {
            String jwtToken = jwtService.generateToken(user);
            revokeAllUserTokens(user);
            saveUserToken(user, jwtToken);
            return AuthenticationResponse.builder().token(jwtToken).idRole(user.getRole().getIdRole()).build();
        }else{
            return null;
        }
    }
    public UserDto getUserDetails(String token) {
        String jwtToken = token.substring(7);
        String userEmail = jwtService.extractUsername(jwtToken);
        Optional<User> user = userRepo.findByEmail(userEmail);
        if (user.isPresent()) {
            return UserMap.toUserDto(user.get());
        } else {
            throw new RuntimeException("user not found");
        }
    }
}
