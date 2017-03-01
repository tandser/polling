package ru.tandser.polling.domain;

import org.hibernate.Hibernate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;

@MappedSuperclass
public abstract class AbstractEntity implements Persistable<Integer> {

    protected Integer       id;
    protected LocalDateTime created;
    protected Boolean       enabled;
    protected int           version;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "created")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Column(name = "enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    @Transient
    public boolean isNew() {
        return getId() == null;
    }

    @PreUpdate
    @PrePersist
    public void prepare() {
        if (getCreated() == null) setCreated(now());
        if (getEnabled() == null) setEnabled(TRUE);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !getClass().equals(Hibernate.getClass(obj))) {
            return false;
        }

        AbstractEntity that = (AbstractEntity) obj;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId() : 0;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id",      getId())
                .add("created", getCreated())
                .add("enabled", getEnabled())
                .add("version", getVersion())
                .toString();
    }
}