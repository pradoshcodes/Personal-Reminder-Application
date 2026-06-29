package com.reminder.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reminder.person.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}