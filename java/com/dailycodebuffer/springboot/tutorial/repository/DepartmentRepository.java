package com.dailycodebuffer.springboot.tutorial.repository;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// JPA repository gives all the methods operations like findAll, findAllByID, saveAndFlush
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
 public Department findByDepartmentNameIgnoreCase(String departmentName);// we are adding this because JPA doesn't have any method for fetching something by name
    public Department findByDepartmentName(String departmentName);
}
