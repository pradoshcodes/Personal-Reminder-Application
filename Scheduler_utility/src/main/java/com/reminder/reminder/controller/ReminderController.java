package com.reminder.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reminder.common.dto.ResponseData;
import com.reminder.reminder.dto.ReminderRequest;
import com.reminder.reminder.service.ReminderService;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping
    public ResponseData saveReminder(@RequestBody ReminderRequest request) {

        return reminderService.saveReminder(request);
    }

}