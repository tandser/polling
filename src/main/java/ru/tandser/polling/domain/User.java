package ru.tandser.polling.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;

@Entity
@Table(name = "users")
@NamedEntityGraph(name = User.WITH_DETAILS, attributeNodes = @NamedAttributeNode("votes"))
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = User.class)
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

    public User() {}

    public User(Integer id, String name, String email, String password, Role role, List<Vote> votes, LocalDateTime created, Boolean enabled, int version) {
        this.id       = id;
        this.name     = name;
        this.email    = email;
        this.password = password;
        this.role     = role;
        this.votes    = votes;
        this.created  = created;
        this.enabled  = enabled;
        this.version  = version;
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

    public void prepare(PasswordEncoder passwordEncoder) {
        setEmail(getEmail().toLowerCase());
        setPassword(passwordEncoder.encode(getPassword()));

        if (getRole()    == null) setRole(Role.USER);
        if (getCreated() == null) setCreated(LocalDateTime.now());
        if (getEnabled() == null) setEnabled(Boolean.TRUE);
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