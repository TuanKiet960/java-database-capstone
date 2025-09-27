package com.project.back_end.controllers;

import com.project.back_end.models.Appointment;
import java.util.List;

/**
 * Placeholder PrescriptionController.
 * In a real Spring project this would be annotated with @RestController
 * and mapped to request paths like /api/prescriptions.
 */
public class PrescriptionController {

    public List<String> getPrescriptionsForPatient(Long patientId) {
        // placeholder implementation
        return java.util.Collections.emptyList();
    }

    public String createPrescription(Long patientId, String prescriptionData) {
        // placeholder implementation
        return "created";
    }
}
