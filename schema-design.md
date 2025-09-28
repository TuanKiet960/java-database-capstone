# Schema Design (MySQL)

## Tables
- `users` (stores common fields and role ENUM 'Doctor','Patient','Admin')
- `doctors` (doctor profiles with FK to users.id)
- `patients` (patient profiles with FK to users.id)
- `appointments` (links doctor_id, patient_id, scheduled_time, status, reason)
- `notifications` (user notifications)

Example `appointments` table excerpt:
```sql
CREATE TABLE appointments (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  patient_id BIGINT NOT NULL,
  doctor_id BIGINT NOT NULL,
  scheduled_time DATETIME NOT NULL,
  status ENUM('PENDING','CONFIRMED','COMPLETED','CANCELLED') DEFAULT 'PENDING',
  reason TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (patient_id) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (doctor_id) REFERENCES users(id) ON DELETE CASCADE
);
```
Notes: add indexes on `scheduled_time`, `doctor_id`, and `patient_id` for performance.
