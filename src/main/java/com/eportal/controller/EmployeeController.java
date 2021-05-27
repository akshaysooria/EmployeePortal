package com.eportal.controller;

import com.eportal.service.EmployeeService;
import com.eportal.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employees employees){
        employeeService.addEmployee(employees);
    }

    @GetMapping("/show")
    public List<Employees> getEmployees(){
        List<Employees> employees= employeeService.getEmployees();
        return employees;
    }

    @GetMapping("/get/{id}")
    public Employees getEmployeeById(@PathVariable("id") String id){
        Long l_id= Long.valueOf(Integer.parseInt(id));
        Employees employees1= employeeService.getEmployeeById(l_id);
        return employees1;
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") String id){
        Long l_id= Long.valueOf(Integer.parseInt(id));
        employeeService.deleteEmployeeById(l_id);
        return "Successfully Deleted";
    }

    @GetMapping("/update/{id}&{newName}")
    public String updateEmployeeNamebyId(@PathVariable("id") String id , @PathVariable("newName") String newName) {
        employeeService.updateEmployeeNamebyId( Long.valueOf(Integer.parseInt(id)),newName);
        return "Successfully updated the name";
    }

    @GetMapping("/update/dept/{id}&{dept}")
    public String updateEmployeeDeptbyId(@PathVariable("id") String id , @PathVariable("dept") String dept) {
        employeeService.updateEmployeeDeptbyId( Long.valueOf(Integer.parseInt(id)), Integer.parseInt(dept));
        return "Successfully updated the departement";
    }



}