package com.example.spring.Dto;

import com.example.spring.Entity.StudentAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class StudentDto {
    @NotNull(message = "Enter roll number")
    @Pattern(regexp = "^.{4}$", message = "Invalid roll number, should have only 4 characters")
    private String rollNumber;
    @NotNull(message = "Enter Name")
    @Pattern(regexp = "^[a-zA-Z.?]+$", message = "Invalid student name")
    private String name;
    @NotNull(message = "Password cannot be empty")
    private String StudentPass;
    @NotNull(message = "Enter department")
    @Pattern(regexp = "^(ECE|EEE|CS)$", message = "Enter 1 of these 4 departments(ECE,EEE,CS)")
    private String department;
    private final String role="STUDENT";
    @Min(value = 1, message = "Enter valid Year")
    @Max(value = 4, message = "Enter valid year")
    private Integer year;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid father name")
    private String fatherName;
    @Valid
    @NotNull(message = "Permanent address cannot be empty")
    private StudentAddress permanentAddress;
    @Valid
    private StudentAddress temporaryAddress;
    @Pattern(regexp = "^[0-9]\\d{9}$", message = "Invalid mobile number")
    private String mobileNumber;
    @Email(message = "Invalid mail id")
    private String email;
}
