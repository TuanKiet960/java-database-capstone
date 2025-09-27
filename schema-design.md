# Schema Design (MySQL)

## Description
This schema is a simple starting point for a clinic appointment system. It uses a single `users` table with a `role` ENUM to store user role (Doctor / Patient / Admin), plus related tables for appointments and records.

## Tables

### `users`
```sql
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  full_name VARCHAR(255),
  role ENUM('Doctor','Patient','Admin') NOT NULL DEFAULT 'Patient',
  phone VARCHAR(50),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### `doctors` (optional - extra profile for doctors)
```sql
CREATE TABLE doctors (
  doctor_id BIGINT PRIMARY KEY,
  specialty VARCHAR(255),
  bio TEXT,
  FOREIGN KEY (doctor_id) REFERENCES users(id) ON DELETE CASCADE
);
```

### `patients` (optional - extra profile for patients)
```sql
CREATE TABLE patients (
  patient_id BIGINT PRIMARY KEY,
  date_of_birth DATE,
  gender VARCHAR(20),
  address TEXT,
  FOREIGN KEY (patient_id) REFERENCES users(id) ON DELETE CASCADE
);
```

### `appointments`
```sql
CREATE TABLE appointments (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  patient_id BIGINT NOT NULL,
  doctor_id BIGINT NOT NULL,
  scheduled_time DATETIME NOT NULL,
  status ENUM('Pending','Confirmed','Completed','Cancelled') DEFAULT 'Pending',
  reason TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (patient_id) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (doctor_id) REFERENCES users(id) ON DELETE CASCADE
);
```

### `notifications`
```sql
CREATE TABLE notifications (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  channel ENUM('EMAIL','SMS','IN_APP') DEFAULT 'IN_APP',
  message TEXT,
  sent_at TIMESTAMP NULL,
  status ENUM('Pending','Sent','Failed') DEFAULT 'Pending',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```

## Notes
- Roles are stored directly in `users.role` as requested (no separate roles table required).
- If you prefer to support dynamic roles in future, create a `roles` table and reference it.
- Indexes should be added on `users.email`, `appointments.scheduled_time`, and foreign keys for performance.
