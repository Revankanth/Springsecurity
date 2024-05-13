package com.example.spring.Service;

import com.example.spring.Dto.*;
import com.example.spring.Entity.StaffEntity;
import com.example.spring.Entity.StudentEntity;
import com.example.spring.Exception.CustomException;
import com.example.spring.Repository.StaffRepo;
import com.example.spring.Repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final StaffRepo staffRepo;
    private final JwtService jwtService;
    private final StudentRepo studentRepo;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse RegisterStaff(StaffDto staff) throws CustomException {
        if (staffRepo.findByStaffKey(staff.getStaffKey())!=null){
            throw new CustomException("Key already exist");
        }else if (studentRepo.findByRollNumber(staff.getStaffKey())!=null){
            throw new CustomException("Invalid staff key");
        }else{
            StaffEntity newStaff = StaffEntity.build(0L, staff.getStaffName(), staff.getStaffKey(), passwordEncoder.encode(staff.getStaffPass()), staff.getRole());
            StaffEntity staffDetails = staffRepo.save(newStaff);
            var jwtToken = jwtService.generateToken(staffDetails);
            return AuthenticationResponse.builder().token(jwtToken).build();
        }
    }

    public AuthenticationResponse AuthenticateStaff(AuthenticationStaffRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getStaffKey(), request.getStaffPass()));
        var staff = staffRepo.findByStaffKey(request.getStaffKey());
        if (staff!=null){
        var jwtToken = jwtService.generateToken(staff);
        return AuthenticationResponse.builder().token(jwtToken).build();
        }else {
            throw new UsernameNotFoundException("user not found");
        }
    }

    public AuthenticationResponse RegisterStudent(StudentDto stud) throws CustomException{
        if(studentRepo.findByRollNumber(stud.getRollNumber())!=null){
            throw new CustomException("Roll number already exist");
        }else {
            StudentEntity student = StudentEntity.build(0L, stud.getRollNumber(), stud.getName(),
                    passwordEncoder.encode(stud.getStudentPass()),
                    stud.getRole(),stud.getDepartment(), stud.getYear(), stud.getFatherName(),
                    stud.getPermanentAddress(), stud.getTemporaryAddress(), stud.getMobileNumber(),
                    stud.getEmail());
            StudentEntity studentDetails = studentRepo.save(student);
            var jwtToken=jwtService.generateToken(studentDetails);
            return AuthenticationResponse.builder().token(jwtToken).build();
        }
    }

    public AuthenticationResponse AuthenticateStudent(AuthenticationStudentRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getRollNumber(), request.getStudentPass()));
        var student = studentRepo.findByRollNumber(request.getRollNumber());
        if (student != null) {
            var jwtToken = jwtService.generateToken(student);
            return AuthenticationResponse.builder().token(jwtToken).build();
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}