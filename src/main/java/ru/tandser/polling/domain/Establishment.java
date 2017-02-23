package ru.tandser.polling.domain;

import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "establishments")
public class Establishment extends AbstractEntity {

    private String     name;
    private String     address;
    private String     phone;
    private String     website;
    private List<Menu> menus;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @OneToMany(mappedBy = "establishment")
    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id",      getId())
                .add("name",    getName())
                .add("phone",   getPhone())
                .add("website", getWebsite())
                .add("created", getCreated())
                .add("enabled", getEnabled())
                .add("version", getVersion())
                .toString();
    }
}