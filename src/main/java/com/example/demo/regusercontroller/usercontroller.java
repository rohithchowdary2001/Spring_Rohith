package com.example.demo.regusercontroller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;
import com.example.demo.regUsersRepo.RegUserRepo;

import com.example.demo.regusersmodel.Register;

import java.util.*;
@RestController
public class usercontroller {

    @Autowired
    private RegUserRepo repo;

    @PostMapping("/register")
    public Register postRegUser(@RequestBody Register reguser) {
        return repo.save(reguser);
    }

    @GetMapping("/getresponse/{email}/{pass}")
    public String getResponse(@PathVariable("email") String email , @PathVariable("pass") String password) {
        List<Register> temp=repo.findByEmail(email); 
        if(temp.size()==0) return "wrong mail";
        List<Register> arr=repo.findByEmailAndPassword(email, password);
        if(arr.size()==0) return "wrong pass";
        else return "ok";
    }

 

}
