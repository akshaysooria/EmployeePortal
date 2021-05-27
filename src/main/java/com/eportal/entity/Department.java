package com.eportal.entity;
import javax.persistence.*;
import java.util.List;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="department")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Department {
    @Id
    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "dept_name")
    private String deptname;

    @Column(name="location")
    private String location;



    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", deptname='" + deptname + '\'' +
                ", location='" + location + '\'' +
                '}';

    }


    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Department() {
    }

    public Department(int dept_id, String deptname, String location) {
        this.dept_id = dept_id;
        this.deptname = deptname;
        this.location = location;
    }
}
