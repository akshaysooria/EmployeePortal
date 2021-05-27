package com.eportal.service;

import com.eportal.entity.Department;
import com.eportal.repo.DepartmentRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentService {

    private static final Logger LOGGER= LogManager.getLogger(DepartmentService.class);

    @Autowired
    DepartmentRepo departmentRepo;

    public boolean addDepartment(Department department){
        boolean result=false;
        try {
            departmentRepo.addDepartment(department);
            result=true;
        }catch(Exception e){
            LOGGER.error("Exception caught"+e);
            result=false;
        }
        finally {
            return result;

        }
    }



    public List<Department> getDepartment(){
        return departmentRepo.geAllDepartment();
    }

//    @Transactional
//    public void updateEmployeeNamebyId (Long empId, String empName){
//        eportalRepo.updateEmployeeNamebyId(empId,empName);
//    }
//
//    @Transactional
//    public void updateEmployeeDeptbyId (Long empId, int dept_id){
//        eportalRepo.updateEmployeeDeptbyId(empId,dept_id);
//    }


    @Transactional
    public boolean deleteDepartmentById(int deptId){
        boolean result=false;
        try{
            departmentRepo.deleteDepartmentById(deptId);
            result=true;
        }catch (Exception e){
            LOGGER.error("Error occured"+e);
            result=false;
        }finally {
            return  result;
        }
    }
}
