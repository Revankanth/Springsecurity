package com.example.spring.Repository;

import com.example.spring.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;

public interface StudentRepo extends JpaRepository<StudentEntity,Long> {

    boolean existsByRollNumber(String rollNumber);

   StudentEntity findByRollNumber(String s);
//   @Modifying
//   @Query(value = "DELETE FROM student_entity WHERE roll_number=?1",nativeQuery = true)
    void deleteByRollNumber(String rollNumber);

}
