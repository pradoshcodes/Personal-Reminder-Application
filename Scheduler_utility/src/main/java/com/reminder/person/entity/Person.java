package com.reminder.person.entity;

import com.reminder.auth.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "people")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "people_seq_gen")
    @SequenceGenerator(
            name = "people_seq_gen",
            sequenceName = "people_seq",
            allocationSize = 1)
    @Column(name = "person_id")
    private Long personId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "notes")
    private String notes;

    @Column(name = "photo_url")
    private String photoUrl;
}