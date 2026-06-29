package com.reminder.reminder.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.reminder.category.entity.Category;
import com.reminder.person.entity.Person;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reminders")
@Getter
@Setter
public class Reminder {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reminders_seq_gen")
    @SequenceGenerator(
            name = "reminders_seq_gen",
            sequenceName = "reminders_seq",
            allocationSize = 1)
    @Column(name = "reminder_id")
    private Long reminderId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "due_time")
    private LocalTime dueTime;

    @Column(name = "priority")
    private String priority;

    @Column(name = "repeat_type")
    private String repeatType;

    @Column(name = "repeat_interval")
    private Integer repeatInterval;

    @Column(name = "notification_enabled")
    private String notificationEnabled;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    
}