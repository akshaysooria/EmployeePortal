package com.eportal.entity;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "employees")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Employees {

    @Id
    @Column(name = "emp_id")
    private long emp_id;

    @Column(name = "emp_name")
    private String emp_name;

    @Column(name="experience")
    private int experience;



    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    public Employees(){

    }
    public Employees(long emp_id, String emp_name, int experience) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.experience = experience;

    }
    @Override
    public String toString() {
        return "Employees{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", experience=" + experience +
                '}';
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
