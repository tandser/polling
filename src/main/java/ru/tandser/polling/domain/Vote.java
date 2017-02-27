package ru.tandser.polling.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static com.google.common.base.MoreObjects.toStringHelper;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "votes")
@NamedEntityGraph(name = Vote.WITH_DETAILS, attributeNodes = {@NamedAttributeNode("menu"), @NamedAttributeNode("user")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Vote.class)
public class Vote extends AbstractEntity {

    public static final String WITH_DETAILS = "Vote.withDetails";

    private Menu    menu;
    private User    user;
    private Integer rating;

    public Vote() {}

    public Vote(Integer id, Menu menu, User user, Integer rating, LocalDateTime created, Boolean enabled, int version) {
        this.id       = id;
        this.menu     = menu;
        this.user     = user;
        this.rating   = rating;
        this.created  = created;
        this.enabled  = enabled;
        this.version  = version;
    }

    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "menu_id")
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id",      getId())
                .add("rating",  getRating())
                .add("created", getCreated())
                .add("enabled", getEnabled())
                .add("version", getVersion())
                .toString();
    }
}