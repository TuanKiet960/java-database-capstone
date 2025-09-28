package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<String> getAvailability(Long doctorId, LocalDate date) {
        Doctor d = doctorRepository.findById(doctorId).orElse(null);
        if (d == null) return java.util.Collections.emptyList();
        String prefix = date.toString();
        return d.getAvailableTimes().stream()
                .filter(t -> t.startsWith(prefix))
                .collect(Collectors.toList());
    }
}
