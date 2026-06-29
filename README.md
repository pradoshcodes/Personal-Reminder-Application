# Personal Reminder Application

A full-stack Personal Reminder Application built with **Spring Boot**, **Flutter**, and **PostgreSQL** to help users manage birthdays, bill payments, anniversaries, interviews, medicines, meetings, and other recurring events from a single platform.

The application is designed using a **modular monolith architecture**, making it easy to maintain today while allowing future migration to microservices if needed.

## ✨ Features

* User Registration & Login
* Category Management
* Person Management (Family, Friends, Colleagues, etc.)
* Reminder Management
* One-time & Recurring Reminders
* Automatic Reminder Occurrence Generation
* Background Scheduler for Due Reminders
* Notification Tracking
* Standard REST APIs
* PostgreSQL Database
* Clean Layered Architecture (Controller → Service → Repository)

## 🏗️ Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* Spring Scheduler
* Maven

### Frontend

* Flutter (In Progress)

### Database

* PostgreSQL

## 📂 Project Structure

```
com.reminder
│
├── auth
├── category
├── person
├── reminder
├── occurrence
├── notification
├── common
├── config
└── security
```

## 📌 Database Modules

* Users
* Categories
* People
* Reminders
* Reminder Occurrences

## 🔄 Reminder Workflow

1. User creates a reminder.
2. Reminder is stored in the `reminders` table.
3. The first reminder occurrence is automatically created in the `reminder_occurrences` table.
4. A background scheduler periodically checks for due reminders.
5. When a reminder becomes due, the notification process is triggered.
6. Notification status is updated to prevent duplicate notifications.
7. For recurring reminders, future occurrences can be generated automatically.

## 📡 REST APIs

* User Registration
* User Login
* Category CRUD
* Person CRUD
* Reminder CRUD
* Reminder Scheduler

## 🚀 Future Enhancements

* JWT Authentication
* Firebase Cloud Messaging (Push Notifications)
* Flutter Mobile Application
* Calendar View
* Dashboard & Analytics
* Reminder Search & Filters
* File Attachments
* Email Notifications
* Natural Language Reminder Input
* Location-Based Reminders

## 🎯 Project Goal

The goal of this project is to build a scalable and production-ready reminder management system that demonstrates best practices in Spring Boot development, REST API design, relational database modeling, scheduling, and clean architecture.

---

**Backend:** Spring Boot + Spring Scheduler + PostgreSQL

**Frontend:** Flutter (Under Development)

**Status:** Backend Core Modules Completed ✅ | Flutter UI Development In Progress 🚀
