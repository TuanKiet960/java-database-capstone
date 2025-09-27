package com.project_back_end.services;

import com.project_back_end.models.Doctor;
import java.util.List;
import java.util.Collections;

/**
 * Placeholder DoctorService.
 * In a Spring app mark this with @Service and inject repositories.
 */
public class DoctorService {

    public List<Doctor> findAllDoctors() {
        return Collections.emptyList();
    }

    public Doctor findById(Long id) {
        return new Doctor(id, "Dr. Placeholder", "General", "doctor@example.com");
    }

    public Doctor save(Doctor doctor) {
        // placeholder save
        return doctor;
    }

    public void deleteById(Long id) {
        // placeholder delete
    }
}
