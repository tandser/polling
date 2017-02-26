package ru.tandser.polling.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;

@Entity
@Table(name = "users")
@NamedEntityGraph(name = User.WITH_DETAILS, attributeNodes = @NamedAttributeNode("votes"))
public class User extends AbstractEntity {

    public static final String WITH_DETAILS = "User.withDetails";

    private String        name;
    private String        email;
    private String        password;
    private Role          role;
    private List<Vote>    votes;

    public enum Role implements GrantedAuthority {
        ADMIN, USER;

        @Override
        public String getAuthority() {
            return "ROLE_" + name();
        }
    }

    @NotBlank
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    @Email
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    @Length(min = 7)
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

    @OneToMany(mappedBy = "user")
    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
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