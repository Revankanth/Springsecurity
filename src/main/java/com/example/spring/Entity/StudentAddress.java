package com.example.spring.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long a;
    private Integer doorNumber;
    private String street;
    private String city;
    private String state;
    private String country;
    @Pattern(regexp = "^\\d{6}$",message = "Enter 6 digit pin code")
    private String pinCode;
}

