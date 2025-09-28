package com.project.back_end.controllers;

import com.project.back_end.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired private TokenService tokenService;

    public static class PrescriptionRequest {
        public Long patientId;
        public String data;
    }

    @PostMapping("/save/{token}")
    public ResponseEntity<?> savePrescription(@PathVariable String token, @RequestBody PrescriptionRequest body) {
        if (!tokenService.validateToken(token)) return ResponseEntity.status(401).body("Invalid token");
        return ResponseEntity.ok("Prescription saved for patient " + body.patientId);
    }
}
