package com.bri.mobile.Entity;

import com.bri.mobile.Enum.StateUser;
import com.bri.mobile.tool.token.Token;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="userTab")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUtilisateur;
    @Column(length=255, nullable=false)
    private String name;
    @Column(length=255, nullable=false)
    private String lastName;
    @Column(length=8, nullable=false)
    private String number;
    @Column(length=255, nullable=false)
    private String password;
    @Column(length=255, nullable=false)
    private String email;
    @Column(length=255, nullable=false)
    private String adress;
    @Column(length=10, nullable=false)
    private String dob;
    @Column(length=2550000)
    private String img;
    @Enumerated(EnumType.STRING)
    private StateUser stateUser;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Role role;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Token> tokens;
    @OneToMany(mappedBy = "user")
    private List<Request> requests;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getNameRole()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}