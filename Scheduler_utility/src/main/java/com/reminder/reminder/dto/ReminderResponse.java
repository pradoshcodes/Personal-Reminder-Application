package com.reminder.reminder.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReminderResponse {

    private Long reminderId;

    private Long categoryId;

    private Long personId;

    private String title;

    private String description;

    private LocalDate dueDate;

    private LocalTime dueTime;

    private String priority;

    private String repeatType;

    private Integer repeatInterval;

    private String notificationEnabled;

    private String status;

}