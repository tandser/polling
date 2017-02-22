package ru.tandser.polling.domain;

import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu extends AbstractEntity {

    private String appetizer;
    private String entree;
    private String beverage;
    private String dessert;

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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id",        getId())
                .add("appetizer", getAppetizer())
                .add("entree",    getEntree())
                .add("beverage",  getBeverage())
                .add("dessert",   getDessert())
                .add("enabled",   getEnabled())
                .add("version",   getVersion())
                .toString();
    }
}