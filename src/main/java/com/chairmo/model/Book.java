package com.chairmo.model;

import com.chairmo.util.Language;
import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class Book implements ObjectModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    private String title;
    private String description;
    private Float unitCost;
    private String isbn;
    private Integer numOfPages;
    private String imageUrl;
    private Language language;

    @ManyToOne
    private Author author;

}
