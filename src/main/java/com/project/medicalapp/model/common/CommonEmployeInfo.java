package com.project.medicalapp.model.common;

import com.project.medicalapp.model.entity.Role;
import com.project.medicalapp.model.entity.Salary;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class CommonEmployeInfo {

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
    @Column(name = "passport_number",nullable = false)
    private String passportNumber;
    @Column(name = "email",nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "common_employe_info_ID")
    private List<Role> roles = new ArrayList<>();

}
