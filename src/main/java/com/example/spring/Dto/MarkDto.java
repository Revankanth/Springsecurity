package com.example.spring.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class MarkDto{
    @NotNull(message = "Enter roll number")
    @Pattern(regexp = "^.{4}$", message = "Invalid roll number, should have only 4 characters")
    private String rollNumber;
    @NotNull(message = "subject1 marks cannot be empty")
    @Min(value = 0,message = "marks cannot be negative")
    @Max(value = 100,message = "Mark cannot exceed 100")
    private Integer subject1;
    @NotNull(message = "subject2 marks cannot be empty")
    @Min(value = 0,message = "marks cannot be negative")
    @Max(value = 100,message = "Mark cannot exceed 100")
    private Integer subject2;
    @NotNull(message = "subject3 marks cannot be empty")
    @Min(value = 0,message = "marks cannot be negative")
    @Max(value = 100,message = "Mark cannot exceed 100")
    private Integer subject3;
    @NotNull(message = "subject4 marks cannot be empty")
    @Min(value = 0,message = "marks cannot be negative")
    @Max(value = 100,message = "Mark cannot exceed 100")
    private Integer subject4;
    @NotNull(message = "subject5 marks cannot be empty")
    @Min(value = 0,message = "marks cannot be negative")
    @Max(value = 100,message = "Mark cannot exceed 100")
    private Integer subject5;
}

