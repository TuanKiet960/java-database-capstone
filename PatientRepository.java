package com.project.back_end.repo;

import com.project.back_end.models.Appointment;
import com.project.back_end.models.Doctor;
import com.project.back_end.models.Patient;

/**
 * Placeholder PatientRepository.
 * In a real Spring Data JPA project this would extend JpaRepository<Patient, Long>
 * and be annotated or picked up by Spring's component scanning.
 */
public interface PatientRepository {
    Patient findById(Long id);
    Patient save(Patient patient);
    void deleteById(Long id);
}
