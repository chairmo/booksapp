package com.chairmo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Data
public class AbstractObjectModel implements ObjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;

    @Basic
    private LocalDate dateCreated;

    @Basic
    private LocalDateTime lastUpdated;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @PrePersist
    @PreUpdate
    public void updateTimeStamp(){
        lastUpdated = LocalDateTime.now();
        if (dateCreated == null)
            dateCreated =LocalDate.now();
    }
}
