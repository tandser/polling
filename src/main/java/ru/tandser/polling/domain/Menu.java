package ru.tandser.polling.domain;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu extends AbstractEntity {

    private String        appetizer;
    private String        entree;
    private String        beverage;
    private String        dessert;
    private Integer       price;
    private Establishment establishment;
    private List<Vote>    votes;

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

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    @OneToMany(mappedBy = "menu")
    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
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