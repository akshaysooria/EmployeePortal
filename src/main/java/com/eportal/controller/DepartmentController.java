package com.eportal.controller;

import com.eportal.service.DepartmentService;
import com.eportal.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @PostMapping("/department")
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @GetMapping("/showDepartment")
    public List<Department> getDepartment(){
        List<Department> department=departmentService.getDepartment();
        return department;
    }

    @GetMapping("/deleteDept/{id}")
    public String deleteDepartmentById(@PathVariable("id") String id){
        int l_id= Integer.parseInt(id);
        departmentService.deleteDepartmentById(l_id);
        return "Successfully Deleted";
    }

}
