package com.example.spring.Controller;

import com.example.spring.Entity.MarkEntity;
import com.example.spring.Exception.CustomException;
import com.example.spring.Service.StudentService;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
@PreAuthorize("hasAnyAuthority('STAFF','STUDENT')")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/profile/{rollNumber}")
    public  ResponseEntity<String> ViewProfile(@PathVariable("rollNumber")String rollNo){
        return new ResponseEntity<>(studentService.ViewStudent(rollNo),HttpStatus.OK);
    }
    @GetMapping("/marks/{rollNumber}")
    public ResponseEntity<MarkEntity> ViewMark(@PathVariable("rollNumber")String rollNo) throws CustomException {
        return new ResponseEntity<>(studentService.StudentMarks(rollNo),HttpStatus.OK);
    }
    @PatchMapping("/updateStudentMail/{rollNumber}/{mail}")
    public ResponseEntity<String> UpdateMail(@PathVariable("rollNumber")String rollNumber, @PathVariable("mail") @Email String email) throws CustomException {
        return new ResponseEntity<>(studentService.UpdateMail(rollNumber,email),HttpStatus.OK);
    }
}