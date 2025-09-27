package com.project.back_end.models;

/**
 * Placeholder Doctor model for submission.
 * Add fields and methods as needed for your project.
 */
public class Doctor {
    private Long id;
    private String fullName;
    private String specialty;
    private String email;

    public Doctor() {}

    public Doctor(Long id, String fullName, String specialty, String email) {
        this.id = id;
        this.fullName = fullName;
        this.specialty = specialty;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
