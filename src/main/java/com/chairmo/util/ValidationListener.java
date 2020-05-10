package com.chairmo.util;

import com.chairmo.model.Author;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ValidationListener {
    @PrePersist
    @PreUpdate
    private void validate(Author author) {
        System.out.println(".ValidationListener validate()");

        if (author.getFirstName() == null || "".equals(author.getFirstName()))
            throw new IllegalArgumentException("Invalid first name");
        if (author.getLastName() == null || "".equals(author.getLastName()))
            throw new IllegalArgumentException("Invalid last name");
    }
}
