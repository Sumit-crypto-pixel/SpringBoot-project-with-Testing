package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


// This is for Service Layer Testing.
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository; // Mock the departmentRepository
    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("Software")
                .departmentAddress("Bengaluru").departmentId(2L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Software"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Data when department Name is valid") // We want this message to show for readability instead of whenValidDepartmentName_thenDepartmentShouldFound
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
     String departmentName = "Software";
   Department found = departmentService.fetchDepartmentByName(departmentName);

   assertEquals(departmentName, found.getDepartmentName());
    }
}