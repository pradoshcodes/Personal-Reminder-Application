package com.reminder.reminder.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reminder.category.entity.Category;
import com.reminder.category.repository.CategoryRepository;
import com.reminder.common.dto.ResponseData;
import com.reminder.occurrence.entity.ReminderOccurrence;
import com.reminder.occurrence.repository.ReminderOccurrenceRepository;
import com.reminder.person.entity.Person;
import com.reminder.person.repository.PersonRepository;
import com.reminder.reminder.dto.ReminderRequest;
import com.reminder.reminder.entity.Reminder;
import com.reminder.reminder.repository.ReminderRepository;

@Service
@Transactional
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ReminderOccurrenceRepository occurrenceRepository;

    public ResponseData saveReminder(ReminderRequest request) {

        ResponseData response = new ResponseData();

        // Validate Category
        Category category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Validate Person
        Person person = personRepository
                .findById(request.getPersonId())
                .orElseThrow(() -> new RuntimeException("Person not found"));

        // Create Reminder
        Reminder reminder = new Reminder();

        reminder.setCategory(category);
        reminder.setPerson(person);

        reminder.setTitle(request.getTitle());
        reminder.setDescription(request.getDescription());

        reminder.setDueDate(request.getDueDate());
        reminder.setDueTime(request.getDueTime());

        reminder.setPriority(request.getPriority());

        reminder.setRepeatType(request.getRepeatType());

        reminder.setRepeatInterval(request.getRepeatInterval());

        reminder.setNotificationEnabled(request.getNotificationEnabled());

        reminder.setStatus("ACTIVE");

        reminder.setCreatedAt(LocalDateTime.now());

        // Save Reminder
        Reminder savedReminder = reminderRepository.save(reminder);

        // Create First Occurrence
        ReminderOccurrence occurrence = new ReminderOccurrence();

        occurrence.setReminder(savedReminder);

        occurrence.setOccurrenceDate(savedReminder.getDueDate());

        occurrence.setOccurrenceTime(savedReminder.getDueTime());

        occurrence.setStatus("PENDING");

        occurrence.setNotificationSent("N");

        occurrenceRepository.save(occurrence);

        // Response
        response.setResponseStatus("success");
        response.setResponseMessage("Reminder created successfully");
        response.setData(savedReminder);

        return response;
    }

}