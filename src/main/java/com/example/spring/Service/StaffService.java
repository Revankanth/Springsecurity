package com.example.spring.Service;

import com.example.spring.Dto.MarkDto;
import com.example.spring.Entity.MarkEntity;
import com.example.spring.Exception.CustomException;
import com.example.spring.Repository.MarkRepo;
import com.example.spring.Repository.StudentRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffService {
    private final MarkRepo markRepo;
    private final StudentRepo studentRepo;
    public List<MarkEntity> SaveMarks(List<MarkDto> marks) throws CustomException{

            List<MarkEntity> savedList=new ArrayList<>();
            for (MarkDto mark:marks) {
                if (studentRepo.existsByRollNumber(mark.getRollNumber())) {
                    if(markRepo.existsByRollNumber(mark.getRollNumber())){
                        throw new CustomException("Mark already entered for the roll number :"+mark.getRollNumber());
                    }else {
                        MarkEntity saveMark=MarkEntity.build(0L,mark.getRollNumber(),mark.getSubject1(),mark.getSubject2(),mark.getSubject3(),mark.getSubject4(),mark.getSubject5());
                    markRepo.save(saveMark);
                    savedList.add(saveMark);}
                }else {
                    throw new CustomException("Roll number does not exist :"+mark.getRollNumber()+", saved marks for :"+savedList.stream().map(MarkEntity::getRollNumber).toList());
                }
            }return savedList;
    }

    public  List<String> GetPercentage(Double percentage) throws CustomException{
        if(percentage>100||percentage<0){
            throw new CustomException("Enter valid percentage, between 0 to 100");
        }else{
           return markRepo.AverageList(percentage).orElseThrow(()->new UsernameNotFoundException("no student with percentage "+ percentage));
        }
    }

    public List<String> CutOffList(Double limit) throws CustomException{
        if(limit<0||limit>200){
            throw new CustomException("Enter valid cut-off, between 0 to 200");
        }
        return markRepo.LimitList(limit).orElseThrow(()->new UsernameNotFoundException("no student with the cut-off "+ limit));
    }

    public String DeleteStudent(String rollNumber) throws CustomException {
        if(studentRepo.findByRollNumber(rollNumber)!=null){
            studentRepo.deleteByRollNumber(rollNumber);
            return ("Deleted :"+rollNumber);
        }else {
            throw new CustomException("roll number doesn't exist, "+rollNumber);
        }
    }
}
