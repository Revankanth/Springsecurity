package com.example.spring.Service;
import com.example.spring.Entity.MarkEntity;
import com.example.spring.Entity.StudentEntity;
import com.example.spring.Exception.CustomException;
import com.example.spring.Repository.MarkRepo;
import com.example.spring.Repository.StudentRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final MarkRepo markRepo;

    public String ViewStudent(String rollNo) {
        StudentEntity student= studentRepo.findByRollNumber(rollNo);
        if (student!=null){
            return ("Name: "+student.getName()+"\n"+"Roll number: "+student.getRollNumber()+"\n"+
                    "Department & Year: "+student.getDepartment()+"-"+student.getYear()+"\n"+
                    "Father Name :"+student.getFatherName()+"\n"+
                    "Permanent Address: \n"+(student.getPermanentStudentAddress().getDoorNumber()+","+
                    student.getPermanentStudentAddress().getStreet()+",\n"+
                    student.getPermanentStudentAddress().getCity()+",\n"+
                    student.getPermanentStudentAddress().getState()+",\n"+
                    student.getPermanentStudentAddress().getCountry()+"\n"+
                    student.getPermanentStudentAddress().getPinCode())+"\n"+
                    "Temporary Address: \n"+(student.getTemporaryStudentAddress().getDoorNumber()+","+
                    student.getTemporaryStudentAddress().getStreet()+",\n"+
                    student.getTemporaryStudentAddress().getCity()+",\n"+
                    student.getTemporaryStudentAddress().getState()+",\n"+
                    student.getTemporaryStudentAddress().getCountry()+"\n"+
                    student.getTemporaryStudentAddress().getPinCode())+"\n"+
                    "Mobile:  "+student.getMobileNumber()+"\n"+"Email: "+student.getEmail());
        }else{
            throw new UsernameNotFoundException("user not found");
        }
    }

    public MarkEntity StudentMarks(String rollNo) throws CustomException {
       return markRepo.findByRollNumber(rollNo).orElseThrow(()->new CustomException("Invalid roll number or marks not updated"));
    }

    public String UpdateMail(String rollNumber, String email) throws CustomException {
        StudentEntity student=studentRepo.findByRollNumber(rollNumber);
        if(student!=null){
            student.setEmail(email);
            studentRepo.save(student);
            return ("mail updated");
        }else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
