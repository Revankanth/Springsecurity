package com.example.spring.Service;
import com.example.spring.Repository.StaffRepo;
import com.example.spring.Repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
    private final StaffRepo staffRepo;
    private final StudentRepo studentRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails staffDetails=staffRepo.findByStaffKey(username);
       if(staffDetails!=null){
           return  staffDetails;
       }else {
           UserDetails studentDetails=studentRepo.findByRollNumber(username);
           if (studentDetails!=null){
               return studentDetails;
           }else {
               throw new UsernameNotFoundException("user not found");
           }
       }
    }
}
