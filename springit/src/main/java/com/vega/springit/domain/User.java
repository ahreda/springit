package com.vega.springit.domain;


import com.vega.springit.domain.validator.PasswordsMatch;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
@PasswordsMatch
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Size(min = 8, max = 20)
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    @Column(length = 100)
    private String password;

    @NonNull
   @Column(nullable = false)
    private boolean enabled;

    @NonNull
    @NotEmpty(message = "Please Enter your First Name")
    private String firstName;

    @NonNull
    @NotEmpty(message = "Please Enter your Last Name")
    private String lastName;

    @Transient
    @Setter(AccessLevel.NONE)
    private String fullName;

    @NonNull
    @NotEmpty(message = "Please enter alias.")
    @Column(nullable = false, unique = true)
    private String alias;

    private String userName;

    @Transient
    @NotEmpty(message = "Please Enter Password confirmation.")
    private String confirmPassword;

    private String activationCode;

    public String getFullName(){
        return firstName + " " + lastName;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role){

        roles.add(role);

    }

    public void addRoles(Set<Role> roles){

        roles.forEach(this::addRole);

    }


    // Return List of authorties ans spring boot need to know about them
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorties = new ArrayList<>();
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

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
        return enabled;
    }
}