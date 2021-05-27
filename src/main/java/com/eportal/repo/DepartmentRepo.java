package com.eportal.repo;

import com.eportal.entity.Department;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DepartmentRepo {

    private static StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
    static MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
    static Metadata metadata = metadataSources.getMetadataBuilder().build();
    private static SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();


    public boolean addDepartment(Department department){

        boolean result=false;
        Session session = null;

        try {
            session=sessionFactory.openSession();
            session.getTransaction().begin();
            session.save(department);
            session.getTransaction().commit();
            result = true;
        }
        catch (Exception e){
            result=false;
        }finally {
            session.close();
        }
        return result;

    }


    @SuppressWarnings("unchecked")
    public List< Department > geAllDepartment() {
        Session session = null;
        List< Department > list;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Department.class);
            list = criteria.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    public boolean deleteDepartmentById(int deptId) {

        boolean result=false;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Department department = session.byId(Department.class).load(deptId);
            session.delete(department);
            session.getTransaction().commit();
            result=true;
        }catch (Exception e){
            result=false;
        }finally {
            session.close();

        }
        return result;
    }
}
