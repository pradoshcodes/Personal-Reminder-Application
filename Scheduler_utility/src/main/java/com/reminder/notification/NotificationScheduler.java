package com.reminder.notification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.reminder.occurrence.entity.ReminderOccurrence;
import com.reminder.occurrence.repository.ReminderOccurrenceRepository;

import jakarta.transaction.Transactional;

@Component
public class NotificationScheduler {

    @Autowired
    private ReminderOccurrenceRepository repository;

    @Transactional
    @Scheduled(cron = "*/10 * * * * *")
    public void checkReminders() {

        List<ReminderOccurrence> reminders =
                repository.findByStatusAndNotificationSent(
                        "PENDING",
                        "N");

        for (ReminderOccurrence occurrence : reminders) {

            if (occurrence.getOccurrenceDate().equals(LocalDate.now())
                    && !occurrence.getOccurrenceTime().isAfter(LocalTime.now())) {

                System.out.println("==================================");
                System.out.println("REMINDER ALERT");
                System.out.println("Title : "
                        + occurrence.getReminder().getTitle());
                System.out.println("Time  : "
                        + occurrence.getOccurrenceTime());
                System.out.println("==================================");

                occurrence.setNotificationSent("Y");
                occurrence.setNotificationSentTime(LocalDateTime.now());

                occurrence.setStatus("SUCCESS");
                repository.save(occurrence);
            }
        }
        
    }
}