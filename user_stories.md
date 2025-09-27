# User Stories

## Overview
This document defines user stories for three roles in the system: **Doctor**, **Patient**, and **Admin**. Each story follows the "As a <role>, I want <goal>, so that <reason>" format.

---

### Doctor
- As a **Doctor**, I want to view my appointment list for the day, so that I can prepare for consultations.
- As a **Doctor**, I want to view patient medical history, so that I can provide appropriate treatment.
- As a **Doctor**, I want to update appointment status (Confirmed / Completed / Cancelled), so that schedule is accurate.
- As a **Doctor**, I want to add notes to a patient's record, so that other doctors and staff can see treatment details.
- As a **Doctor**, I want to receive notifications for new appointments or cancellations, so that I can adjust my schedule.

### Patient
- As a **Patient**, I want to create an account and manage my profile, so that my personal and contact details are available.
- As a **Patient**, I want to book an appointment with a doctor, so that I can get medical help.
- As a **Patient**, I want to view and cancel my upcoming appointments, so that I can manage my schedule.
- As a **Patient**, I want to receive appointment reminders (email/SMS), so that I don't miss appointments.
- As a **Patient**, I want to view my medical records and appointment history, so that I can track past treatments.

### Admin
- As an **Admin**, I want to manage user accounts (create, update, delete), so that system users are maintained.
- As an **Admin**, I want to assign or change user roles (Doctor / Patient / Admin), so that access rights are correct.
- As an **Admin**, I want to view and manage all appointments, so that I can reschedule or reassign when needed.
- As an **Admin**, I want to configure notification templates and channels, so that communications are consistent.
- As an **Admin**, I want to view system reports (appointments per doctor, cancellations, active users), so that I can monitor system usage.

---

## Acceptance Criteria (example)
- Each user can only access pages permitted by their role.
- Patients can book appointments only for available time slots.
- Doctors see only their own appointments.
- Admins can change roles directly on the user's record without creating new tables.

