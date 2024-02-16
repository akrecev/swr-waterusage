package ru.rosniivh.swr.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serial;
import java.time.LocalDate;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.rosniivh.swr.domain.auth.UserEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwrUser implements UserDetails {
    @Serial
    private static final long serialVersionUID = 354547179488192984L;

    private int id;
    private String username;

    @JsonIgnore
    private String password;

    private String email;

    @JsonIgnore
    private LocalDate lastPasswordReset;

    private Collection<? extends GrantedAuthority> authorities;

    @JsonIgnore
    private Boolean accountNonExpired = true;

    @JsonIgnore
    private Boolean accountNonLocked = true;

    @JsonIgnore
    private Boolean credentialsNonExpired = true;

    @JsonIgnore
    private Boolean enabled = true;

    private UserEntity user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
