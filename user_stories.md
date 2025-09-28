# User Stories

## Doctor
- As a **Doctor**, I want to view my appointments for a selected day, so that I can prepare for consultations.
- As a **Doctor**, I want to update appointment status (Confirmed / Completed / Cancelled), so that records are accurate.
- As a **Doctor**, I want to add notes to a patient's appointment, so that other clinicians can see treatment details.
- As a **Doctor**, I want to set available time slots for a date, so patients can book consultations.
- As a **Doctor**, I want to receive notifications for new bookings or cancellations, so I can adjust my schedule.

## Patient
- As a **Patient**, I want to create an account and update my profile, so that contact information is current.
- As a **Patient**, I want to search doctors by specialty/time and view available slots, so I can book appointments.
- As a **Patient**, I want to book, view and cancel my appointments, so I can manage my visits.
- As a **Patient**, I want to receive SMS/email reminders for upcoming appointments, so I don't miss them.
- As a **Patient**, I want to view my past appointment history and prescriptions, so I can track care.

## Admin
- As an **Admin**, I want to manage users and roles directly on the User record, so I can control access without extra tables.
- As an **Admin**, I want to add doctors and manage doctor profiles (specialty, available times), so the system can accept bookings.
- As an **Admin**, I want to view system reports (appointments by doctor, cancellations), so I can monitor clinic load.
- As an **Admin**, I want to configure notification templates (email/SMS), so communications to patients are consistent.
- As an **Admin**, I want to run data exports for audit and backups.

## Acceptance Criteria (examples)
- Roles stored on `users.role` (ENUM) and changeable from Admin UI.
- Entity classes use JPA annotations (@Entity, @Id, @GeneratedValue) and relations where appropriate.
- APIs follow REST patterns and require token authentication for protected actions.
- Provide screenshots for the required UI views and outputs for the SQL reports/curl responses.
