package com.project.back_end.controllers;

import com.project.back_end.services.DoctorService;
import com.project.back_end.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired private DoctorService doctorService;
    @Autowired private TokenService tokenService;

    @GetMapping("/availability/{user}/{doctorId}/{date}/{token}")
    public ResponseEntity<?> availabilityByPath(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @PathVariable String token) {

        if (!tokenService.validateToken(token)) return ResponseEntity.status(401).body("Invalid token");
        List<String> slots = doctorService.getAvailability(doctorId, date);
        return ResponseEntity.ok(slots);
    }
}
