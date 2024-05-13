package com.example.spring.Repository;

import com.example.spring.Entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<StaffEntity,Long> {

    StaffEntity findByStaffKey(String key);
}
