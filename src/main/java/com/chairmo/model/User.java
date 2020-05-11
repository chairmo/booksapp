package com.chairmo.model;

import com.chairmo.model.role.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends AbstractObjectModel {

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
    private Cart cart;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Customer customer;

    @ManyToMany
    @JoinTable
    private List<Role> roles = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void addRole(Role role){
        if (!this.roles.contains(role)){
            this.roles.add(role);
        }
        if (!role.getUsers().contains(this)){
            role.getUsers().add(this);
        }
    }
    public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }
}
