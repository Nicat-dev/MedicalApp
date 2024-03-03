package com.project.medicalapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class CommonUserInfo {
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
    @Column(name = "passport_number",nullable = false)
    private String passportNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "age",nullable = false)
    private Integer age;
    @Column(name = "citizenship",nullable = false)
    private String citizenship;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false,updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;
}
