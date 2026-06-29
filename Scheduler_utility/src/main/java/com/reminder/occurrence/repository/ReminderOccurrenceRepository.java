package com.reminder.occurrence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reminder.occurrence.entity.ReminderOccurrence;

@Repository
public interface ReminderOccurrenceRepository extends JpaRepository<ReminderOccurrence, Long> {

    List<ReminderOccurrence> findByStatusAndNotificationSent(
            String status,
            String notificationSent);

}