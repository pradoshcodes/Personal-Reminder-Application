package com.reminder.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reminder.common.dto.ResponseData;
import com.reminder.person.entity.Person;
import com.reminder.person.service.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public Person save(@RequestBody Person person) {
        return service.save(person);
    }

    @GetMapping
    public ResponseData getAll() {

        ResponseData response = new ResponseData();

        response.setResponseStatus("SUCCESS");
        response.setResponseMessage("Persons fetched successfully");
        response.setData(service.getAll());

        return response;
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}