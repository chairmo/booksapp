package com.chairmo.model;

import lombok.Data;
import org.springframework.data.annotation.Version;

import javax.persistence.*;

@Data
@Entity
public class User implements ObjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    private String username;

    @Transient
    private String password;

    private String encryptedPassword;
    private Boolean enabled = true;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Author author;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    public Author author() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        author.setUser(this);
    }
}
