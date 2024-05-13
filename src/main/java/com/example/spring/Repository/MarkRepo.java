package com.example.spring.Repository;

import com.example.spring.Entity.MarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface MarkRepo extends JpaRepository<MarkEntity,Long> {
    Optional<MarkEntity> findByRollNumber(String rollNo);

    boolean existsByRollNumber(String rollNumber);
    @Query(value ="select roll_number from mark_entity where ((subject1+mark_entity.subject2)/2+mark_entity.subject3)>=?1 order by ((subject1+mark_entity.subject2)/2+mark_entity.subject3)desc ",nativeQuery = true)
    Optional<List<String>> LimitList(Double limit);
    @Query(value ="select roll_number from mark_entity where (((subject1+mark_entity.subject2+mark_entity.subject3+mark_entity.subject4+mark_entity.subject5)/5)>=?1)" ,nativeQuery = true)
    Optional<List<String>> AverageList(Double average);
}
