package com.example.spring.Dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationStaffRequest {
    private String staffKey;
    private String staffPass;
}
//{
//        "staffKey":12345,
//        "staffPass":54321
//        }
//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NSIsImF1ZCI6IltTVEFGRl0iLCJpYXQiOjE3MTU1ODY5MjQsImV4cCI6MTcxNTY3MzMyNH0.uJfODixNsiHtjZzYUvehIG3btaa3hbklwKMCdyInCUU