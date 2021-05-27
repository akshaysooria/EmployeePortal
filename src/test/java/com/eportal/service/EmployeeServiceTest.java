package com.eportal.service;

import com.eportal.entity.Department;
import com.eportal.repo.DepartmentRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.eportal.entity.Employees;
import com.eportal.repo.EmployeeRepo;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    static EmployeeRepo employeeRepo;
    static DepartmentRepo departmentRepo;

    @BeforeAll
    public static void setup(){
        employeeRepo=new EmployeeRepo();
        departmentRepo=new DepartmentRepo();
    }

    @Test
    public void insertEmployee(){
        Department department=new Department(7,"testing","usa");
        departmentRepo.addDepartment(department);
        Employees employees=new Employees();
        employees.setEmp_id(7);
        employees.setEmp_name("rajesh");
        employees.setExperience(4);
        employees.setDepartment(department);
        boolean result=employeeRepo.addEmployee(employees);
        assertEquals(true,result);
    }

    @Test
    public void deleteEmployeeTest(){
        boolean result=employeeRepo.deleteEmployeeById(7L);
        assertEquals(true,result);
    }

    @Test
    public void deleteEmployeeTestNeagtive(){
        boolean result=employeeRepo.deleteEmployeeById(8L);
        assertEquals(false,result);
    }

    @Test
    public void updateEmployeeByDeptTest(){
        boolean result=employeeRepo.updateEmployeeDeptbyId (7L,0);
        assertEquals(true,result);
    }

    @Test
    public void updateEmployeeByDeptTestNegative(){
        boolean result=employeeRepo.updateEmployeeDeptbyId (9L,2);
        assertEquals(false,result);
    }

    @Test
    public void updateEmployeeByIdTest(){
        boolean result=employeeRepo.updateEmployeeNamebyId(7L,"Dev");
        assertEquals(true,result);
    }

    @Test
    public void updateEmployeeByIdTestNegative(){
        boolean result=employeeRepo.updateEmployeeNamebyId(9L,"Dev");
        assertEquals(true,result);
    }

}