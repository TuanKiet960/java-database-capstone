package com.project.back_end.models;

import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name") private String fullName;
    private String email;
    private String phone;
    public Patient() {}
    public Patient(Long id, String fullName, String email, String phone) {
        this.id = id; this.fullName = fullName; this.email = email; this.phone = phone;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
