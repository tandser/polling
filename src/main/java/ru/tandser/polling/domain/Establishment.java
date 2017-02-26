package ru.tandser.polling.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;

@Entity
@Table(name = "establishments")
@NamedEntityGraph(name = Establishment.WITH_DETAILS, attributeNodes = @NamedAttributeNode("menus"))
public class Establishment extends AbstractEntity {

    public static final String WITH_DETAILS = "Establishment.withDetails";

    private String     name;
    private String     address;
    private String     phone;
    private String     website;
    private List<Menu> menus;

    @NotBlank
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotBlank
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @URL
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
        return toStringHelper(this)
                .add("id",      getId())
                .add("name",    getName())
                .add("address", getAddress())
                .add("phone",   getPhone())
                .add("website", getWebsite())
                .add("created", getCreated())
                .add("enabled", getEnabled())
                .add("version", getVersion())
                .toString();
    }
}