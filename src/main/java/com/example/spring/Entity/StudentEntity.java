package com.example.spring.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s;
    private String rollNumber;
    private String name;
    private String studentPass;
    private String role;
    private String department;
    private  Integer year;
    private String fatherName;
    @OneToOne(cascade=CascadeType.ALL,orphanRemoval = true)
    private StudentAddress permanentStudentAddress;
    @OneToOne(cascade=CascadeType.ALL,orphanRemoval = true)
    private StudentAddress temporaryStudentAddress;
    private String mobileNumber;
    private String email;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return studentPass;
    }

    @Override
    public String getUsername() {
        return rollNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
//{
//    "rollNumber":1234,
//        "name":"A.Ram",
//        "studentPass":4321,
//        "department":"CS",
//        "year":4,
//        "fatherName":"Shiva",
//        "permanentAddress":{
//    "doorNumber":15,
//            "street":"Annasalai",
//            "city":"Rasipuram",
//            "state":"TamilNadu",
//            "country":"India",
//            "pinCode":656545
//},
//    "temporaryAddress":{
//    "doorNumber":16,
//            "street":"Annasalai",
//            "city":"Rasipuram",
//            "state":"TamilNadu",
//            "country":"India",
//            "pinCode":656545
//},
//    "mobileNumber":9876543213,
//        "email":"ram@gmail.com"
//}
