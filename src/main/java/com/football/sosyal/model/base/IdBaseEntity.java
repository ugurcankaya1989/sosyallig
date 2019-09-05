package com.football.sosyal.model.base;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class IdBaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "VERSION")
    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
