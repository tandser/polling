package ru.tandser.polling.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.google.common.base.MoreObjects.toStringHelper;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "menus")
@NamedEntityGraph(name = Menu.WITH_DETAILS, attributeNodes = {@NamedAttributeNode("establishment"), @NamedAttributeNode("votes")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Menu.class)
public class Menu extends AbstractEntity {

    public static final String WITH_DETAILS = "Menu.withDetails";

    private String        appetizer;
    private String        entree;
    private String        beverage;
    private String        dessert;
    private Integer       price;
    private Establishment establishment;
    private List<Vote>    votes;

    public Menu() {}

    public Menu(Integer id, String appetizer, String entree, String beverage, String dessert, Integer price, Establishment establishment, List<Vote> votes, LocalDateTime created, Boolean enabled, int version) {
        this.id            = id;
        this.appetizer     = appetizer;
        this.entree        = entree;
        this.beverage      = beverage;
        this.dessert       = dessert;
        this.price         = price;
        this.establishment = establishment;
        this.votes         = votes;
        this.created       = created;
        this.enabled       = enabled;
        this.version       = version;
    }

    @Column(name = "appetizer")
    public String getAppetizer() {
        return appetizer;
    }

    public void setAppetizer(String appetizer) {
        this.appetizer = appetizer;
    }

    @Column(name = "entree")
    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    @Column(name = "beverage")
    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    @Column(name = "dessert")
    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "establishment_id")
    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    @JsonInclude(NON_EMPTY)
    @OneToMany(mappedBy = "menu")
    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id",        getId())
                .add("appetizer", getAppetizer())
                .add("entree",    getEntree())
                .add("beverage",  getBeverage())
                .add("dessert",   getDessert())
                .add("price",     getPrice())
                .add("created",   getCreated())
                .add("enabled",   getEnabled())
                .add("version",   getVersion())
                .toString();
    }
}