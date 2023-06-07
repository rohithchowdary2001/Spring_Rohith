package com.example.demo.regUsersRepo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.regusersmodel.Register;

public interface RegUserRepo extends JpaRepository<Register, Long>{

    List<Register> findByEmailAndPassword(String email,String password);

    List<Register> findByEmail(String email);

 

}