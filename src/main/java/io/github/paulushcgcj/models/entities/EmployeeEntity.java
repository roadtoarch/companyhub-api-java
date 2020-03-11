package io.github.paulushcgcj.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50,nullable = false)
    private String firstName;
    @Column(length = 50,nullable = false)
    private String lastName;
    @Column(length = 50,nullable = false)
    private String email;
    @Column(length = 50,nullable = false)
    private String username;
    @Column(length = 50,nullable = false)
    private String phone;
    @Column(length = 50,nullable = false)
    private String jobTitle;
    @Column(length = 50,nullable = false)
    private String department;
    @Column(length = 50,nullable = false)
    private String ein;
    @Column(length = 50,nullable = false)
    private String gender;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(length = 50,nullable = false)
    private String machineIp;

    @ManyToOne
    @JoinColumn(name = "campus_id",nullable = false)
    private CampusEntity campus;
}
