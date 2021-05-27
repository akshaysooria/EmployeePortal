package com.eportal.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.eportal.entity.Department;
import com.eportal.repo.DepartmentRepo;
import static org.junit.jupiter.api.Assertions.*;

public class DepartmentServiceTest {

    static DepartmentRepo departmentRepo;
    static DepartmentService departmentService;

    @BeforeAll
    public static void setup(){
        departmentRepo=new DepartmentRepo();
    }

    @Test
    public void createEmployeeTest()
    {
        Department dept= new Department(4,"Testing","japan");
        boolean result=departmentRepo.addDepartment(dept);
        assertEquals(true,result);
    }

    @Test
    public void deleteEmployeeTest(){
        boolean result=departmentRepo.deleteDepartmentById(4);
        assertEquals(true,result);
    }

    @Test
    public void deleteEmployeeTestNegative(){
        boolean result=departmentRepo.deleteDepartmentById(21);
        System.out.println("No such Id in the table");
        assertEquals(true,result);

    }

    @Test
    public void checkServiceTest(){
        departmentService = new DepartmentService();
        assertNotNull(departmentService);
    }


    @Test
    public void checkRepoTest(){
        departmentRepo = new DepartmentRepo();
        assertNotNull(departmentRepo);
    }

}


