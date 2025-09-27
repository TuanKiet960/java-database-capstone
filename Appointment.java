package com.project.back_end.models;

import java.time.LocalDateTime;

/**
 * Placeholder Appointment model for submission.
 */
public class Appointment {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime scheduledTime;
    private String status;
    private String reason;

    public Appointment() {}

    public Appointment(Long id, Long patientId, Long doctorId, LocalDateTime scheduledTime, String status, String reason) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.scheduledTime = scheduledTime;
        this.status = status;
        this.reason = reason;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(LocalDateTime scheduledTime) { this.scheduledTime = scheduledTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
