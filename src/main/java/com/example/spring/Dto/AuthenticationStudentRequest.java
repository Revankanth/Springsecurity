package com.example.spring.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationStudentRequest {
    private String rollNumber;
    private String studentPass;
}
//{
//        "rollNumber":1234,
//        "studentPass":4321
//        }
//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0IiwiYXVkIjoiW1NUVURFTlRdIiwiaWF0IjoxNzE1NTg3MjkzLCJleHAiOjE3MTU2NzM2OTN9.U6xH-kL41y5AoK3doeWIkDkmQH8Uv379aEnvSLZjNaY
