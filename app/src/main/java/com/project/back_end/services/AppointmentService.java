package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import com.project.back_end.models.Patient;
import com.project.back_end.models.Doctor;
import com.project.back_end.repo.AppointmentRepository;
import com.project.back_end.repo.PatientRepository;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired private AppointmentRepository appointmentRepository;
    @Autowired private PatientRepository patientRepository;
    @Autowired private DoctorRepository doctorRepository;

    public Appointment bookAppointment(Long patientId, Long doctorId, LocalDateTime time, String reason) {
        Patient p = patientRepository.findById(patientId).orElseThrow();
        Doctor d = doctorRepository.findById(doctorId).orElseThrow();
        Appointment a = new Appointment();
        a.setPatient(p); a.setDoctor(d); a.setScheduledTime(time); a.setStatus(Appointment.Status.PENDING);
        a.setReason(reason);
        return appointmentRepository.save(a);
    }

    public List<Appointment> getAppointmentsForDoctorByDate(Long doctorId, LocalDateTime from, LocalDateTime to) {
        return appointmentRepository.findByDoctorIdAndScheduledTimeBetween(doctorId, from, to);
    }

    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}
