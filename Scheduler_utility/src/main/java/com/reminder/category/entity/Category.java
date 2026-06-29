package com.reminder.category.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "categories_seq_gen")
    @SequenceGenerator(
            name = "categories_seq_gen",
            sequenceName = "categories_seq",
            allocationSize = 1)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "icon_name")
    private String iconName;

    @Column(name = "color_code")
    private String colorCode;
}