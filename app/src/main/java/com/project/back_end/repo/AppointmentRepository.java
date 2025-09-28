package com.project.back_end.repo;

import com.project.back_end.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorIdAndScheduledTimeBetween(Long doctorId, LocalDateTime from, LocalDateTime to);
    List<Appointment> findByPatientId(Long patientId);
}
