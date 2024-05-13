package com.example.spring.Controller;

import com.example.spring.Dto.*;
import com.example.spring.Exception.CustomException;
import com.example.spring.Service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register/staff")
    public ResponseEntity<AuthenticationResponse> RegisterUser(@Valid @RequestBody StaffDto staff) throws CustomException {
        return new ResponseEntity<>(authService.RegisterStaff(staff), HttpStatus.OK);
    }
    @PostMapping("/authenticate/staff")
    public ResponseEntity<AuthenticationResponse> AuthenticateUser(@RequestBody AuthenticationStaffRequest request ){
        return new ResponseEntity<>(authService.AuthenticateStaff(request),HttpStatus.OK);
    }
    @PostMapping("/register/student")
    public ResponseEntity<AuthenticationResponse> RegisterStudent(@Valid @RequestBody StudentDto stud) throws CustomException {
        return new ResponseEntity<>(authService.RegisterStudent(stud),HttpStatus.OK);
    }
    @PostMapping("/authenticate/student")
    public ResponseEntity<AuthenticationResponse> AuthenticateStudent(@RequestBody AuthenticationStudentRequest request){
        return new ResponseEntity<>(authService.AuthenticateStudent(request),HttpStatus.OK);
    }
}
