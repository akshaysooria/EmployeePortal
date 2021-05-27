package com.eportal.service;
import java.util.List;

import com.eportal.entity.Employees;
import com.eportal.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public boolean addEmployee(Employees employees){
        boolean result=false;
        try {
            employeeRepo.addEmployee(employees);
            result=true;
        }catch(Exception e){

            result=false;
        }
        finally {
            return result;

        }
    }

    public Employees getEmployeeById(Long emp_Id){
        Employees x= employeeRepo.getEmployeeById(emp_Id);
        return x;
    }

    public List<Employees> getEmployees(){
        return employeeRepo.geAllEmployees();
    }

    @Transactional
    public void updateEmployeeNamebyId (Long empId, String empName){
        employeeRepo.updateEmployeeNamebyId(empId,empName);
    }

    @Transactional
    public void updateEmployeeDeptbyId (Long empId, int dept_id){
        employeeRepo.updateEmployeeDeptbyId(empId,dept_id);
    }


    @Transactional
    public void deleteEmployeeById(Long empId){
        employeeRepo.deleteEmployeeById(empId);
    }
}
