package com.example.spring.Controller;

import com.example.spring.Dto.MarkDto;
import com.example.spring.Entity.MarkEntity;
import com.example.spring.Exception.CustomException;
import com.example.spring.Service.StaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/staff")
@PreAuthorize("hasAuthority('STAFF')")
public class StaffController {
    private final StaffService staffService;

    @PostMapping("/addMarks")
    public ResponseEntity<List<MarkEntity>> AddMarks(@Valid @RequestBody List<MarkDto> marks) throws CustomException {
        return new ResponseEntity<>(staffService.SaveMarks(marks),HttpStatus.OK);
    }
    @GetMapping("/percentageList/{percentage}")
    public ResponseEntity <List<String>> StudentList(@PathVariable("percentage") Double percent) throws CustomException {
        return new ResponseEntity<>(staffService.GetPercentage(percent),HttpStatus.OK);
    }
    @GetMapping("/cutoff/{cutoff}")
    public ResponseEntity<List<String>> CutOffAbove(@PathVariable("cutoff")Double limit) throws CustomException {
        return new ResponseEntity<>(staffService.CutOffList(limit),HttpStatus.OK);
    }
    @DeleteMapping("/deleteStudent/{rollNumber}")
    public ResponseEntity<String> DeleteStudent(@PathVariable("rollNumber")String roll) throws CustomException {
        return new ResponseEntity<>(staffService.DeleteStudent(roll),HttpStatus.OK);
    }
}
