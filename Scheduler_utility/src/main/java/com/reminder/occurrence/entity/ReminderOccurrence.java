package com.reminder.occurrence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.reminder.reminder.entity.Reminder;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reminder_occurrences")
@Getter
@Setter
public class ReminderOccurrence {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reminder_occurrence_seq_gen")
    @SequenceGenerator(
            name = "reminder_occurrence_seq_gen",
            sequenceName = "reminder_occurrences_seq",
            allocationSize = 1)
    @Column(name = "occurrence_id")
    private Long occurrenceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reminder_id")
    private Reminder reminder;

    @Column(name = "occurrence_date")
    private LocalDate occurrenceDate;

    @Column(name = "occurrence_time")
    private LocalTime occurrenceTime;

    @Column(name = "status")
    private String status;

    @Column(name = "completed_date")
    private LocalDateTime completedDate;
    @Column(name = "notification_sent")
    private String notificationSent;

    @Column(name = "notification_sent_time")
    private LocalDateTime notificationSentTime;
}