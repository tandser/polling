package ru.tandser.polling.domain;

import com.google.common.base.MoreObjects;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    private String        name;
    private String        email;
    private String        password;
    private Role          role;

    public enum Role implements GrantedAuthority {
        ADMIN, USER;

        @Override
        public String getAuthority() {
            return "ROLE_" + name();
        }
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id",      getId())
                .add("name",    getName())
                .add("email",   getEmail())
                .add("role",    getRole())
                .add("created", getCreated())
                .add("enabled", getEnabled())
                .add("version", getVersion())
                .toString();
    }
}