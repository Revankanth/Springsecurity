package com.example.spring.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class MarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long m;
    private String rollNumber;
    private Integer subject1;
    private Integer subject2;
    private Integer subject3;
    private Integer subject4;
    private Integer subject5;
}
//[{
//        "rollNumber":"1124",
//        "subject1":80,
//        "subject2":90,
//        "subject3":88,
//        "subject4":86,
//        "subject5":67
//        },{
//        "rollNumber":"1134",
//        "subject1":87,
//        "subject2":65,
//        "subject3":90,
//        "subject4":86,
//        "subject5":100
//        },{
//        "rollNumber":"1130",
//        "subject1":98,
//        "subject2":46,
//        "subject3":89,
//        "subject4":65,
//        "subject5":70
//        }]
