package ru.tandser.polling.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "establishments")
public class Establishment extends AbstractEntity {

    private String name;
    private String address;
    private String phone;
    private String website;
}