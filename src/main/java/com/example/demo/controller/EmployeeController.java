package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
     @Autowired
	 private EmployeeRepository employeeRepository;
     

     
     @GetMapping("/details")
     public  List<Employee> getAllEmployees(){
    	 
    	 return employeeRepository.findAll();
    	 
     }
  
     
     @PostMapping("/details")
     public Employee createEmployee(@RequestBody Employee employee)
     {
    	 return employeeRepository.save(employee);
     }
     
     
     @GetMapping("/details/{id}")
     public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    	 Employee employee =employeeRepository.findById(id)
    			 .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+id));
    	 
    	 return ResponseEntity.ok(employee);
    	 
     }
  
     
     @PutMapping("/details/{id}")
     public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
    	 
    	 Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:"+id));
    	
    	 employee.setName(employeeDetails.getName());
       	 employee.setDepartment(employeeDetails.getDepartment());
    	 employee.setSalary(employeeDetails.getSalary());
    	 employee.setGender(employeeDetails.getGender());
    	 employee.setDob(employeeDetails.getDob());

    	 
    	 Employee updatedEmployee = employeeRepository.save(employee);
    	 return ResponseEntity.ok(updatedEmployee);

    	 
     }
    
     @DeleteMapping("/details/{id}")
     public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
    	 Employee employee = employeeRepository.findById(id)
    			 .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:"+id));
    	 
         employeeRepository.delete(employee);
         Map<String, Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return  ResponseEntity.ok(response);
         
     }
     
	 
}
