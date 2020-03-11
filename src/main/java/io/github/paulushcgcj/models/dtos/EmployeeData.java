package io.github.paulushcgcj.models.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeData {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String phone;
    private String jobTitle;
    private String department;
    private String ein;
    private String gender;
    private LocalDate dob;
    private String machineIp;
    private String campus;
    private String company;
}
