package com.eportal.repo;
import com.eportal.entity.Department;
import com.eportal.entity.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EmployeeRepo {
    private static final Logger LOGGER=LogManager.getLogger(EmployeeRepo.class);

    private static StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();


    static MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
    static Metadata metadata = metadataSources.getMetadataBuilder().build();
    private static SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();

    public boolean addEmployee(Employees employees){
        boolean result=false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.save(employees);
            LOGGER.debug("Saveds " + employees);
            session.getTransaction().commit();
            result=true;
        }catch (Exception e){
            result=false;
        }finally {
            session.close();
        }

        return result;

    }

    public Employees getEmployeeById(Long emp_Id) {
        Session session = null;
        Employees employees = null;
        try {
            session = sessionFactory.openSession();
            employees = (Employees) session.get(Employees.class,emp_Id);
            LOGGER.info("Session Opened");

        } finally {
            if (session != null) {
                session.close();
                LOGGER.info("Session Closed");
            }
        }

        return employees;
    }

    @SuppressWarnings("unchecked")
    public List< Employees > geAllEmployees() {
        Session session = null;
        List< Employees > list;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employees.class);
            list = criteria.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        LOGGER.info("fetch successful");
        return list;

    }

    public boolean updateEmployeeNamebyId (Long empId, String empName)
    {
        boolean result=false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Employees employees = session.byId(Employees.class).load(empId);
            employees.setEmp_name(empName);
            session.update(employees);
            session.getTransaction().commit();
            LOGGER.debug("transaction committed");
            result = true;
        }catch(Exception e){
            result = false;
        }finally {
            session.close();
            LOGGER.info("Session Closed");

        }
        return result;
    }
    public boolean updateEmployeeDeptbyId (Long empId, int dept_id)
    {
        boolean result=false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Department department = session.byId(Department.class).load(dept_id);
            Employees employees = session.byId(Employees.class).load(empId);
            employees.setDepartment(department);
            session.update(employees);
            session.getTransaction().commit();
            LOGGER.debug("transaction committed");
            result=true;
        }catch (Exception e) {
            result = false;
        }finally {
            session.close();
            LOGGER.info("Session Closed");
        }
        return result;

    }
    public boolean deleteEmployeeById(Long empId) {


        boolean result=false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Employees emps = session.byId(Employees.class).load(empId);
            session.delete(emps);
            session.getTransaction().commit();
            LOGGER.debug("transaction committed");
            result=true;
        }catch (Exception e) {
            result = false;
        }finally {
            session.close();
            LOGGER.info("Session Closed");
        }
        return result;
    }


}
