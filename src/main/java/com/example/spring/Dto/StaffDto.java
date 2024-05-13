package com.example.spring.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StaffDto {
    @Pattern(regexp = "^[a-zA-Z.?]+$",message = "Enter valid staff name")
    @NotBlank
    private String staffName;
    @Pattern(regexp = "^.{5}$",message = "Invalid staff key, should've only 5 characters")
    private String staffKey;
    @NotNull(message = "Password cannot be empty")
    private String staffPass;
    private final String role="STAFF";
}
