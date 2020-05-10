package com.chairmo.util;

import com.chairmo.model.Author;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorListener {

    @PostLoad
    @PostPersist
    @PostUpdate
    private void calculateAge(Author author){
        System.out.println(".AgeCalculatorListener");
        if (author.getDob() == null){
            author.setDob(null);
        }
        author.setAge(Period.between(author.getDob(), LocalDate.now()).getYears());
    }
}
