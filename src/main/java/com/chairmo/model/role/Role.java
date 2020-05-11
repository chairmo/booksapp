package com.chairmo.model.role;

import com.chairmo.model.AbstractObjectModel;
import com.chairmo.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Role extends AbstractObjectModel {

    private String role;

    @ManyToMany
    @JoinTable
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        if (!this.users.contains(user)){
            this.users.add(user);
        }
        if (!user.getRoles().contains(this)){
            user.getRoles().add(this);
        }
    }
    public void removeUser(User user){
        this.users.remove(user);
        user.getRoles().remove(this);
    }
}
