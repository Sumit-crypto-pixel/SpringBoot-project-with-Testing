package com.dailycodebuffer.springboot.tutorial.controller;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.print.attribute.standard.Media;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;
// Testing controller layer is bit different, it needs end-point to execute so we will also provide end-points for testing

@WebMvcTest(DepartmentController.class) // for endpoints
class DepartmentControllerTest {

@Autowired
    private MockMvc mockMvc;
 @MockBean  // to mock service layer.
private DepartmentService departmentService;

 private Department department;

    @BeforeEach
    void setUp() {  // This is the object which I have created.
        department = Department.builder()
                .departmentAddress("Kolkatta")
                .departmentCode("Support-101")
                .departmentName("IT-Support")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Kanpur")
                .departmentCode("ME-101")
                .departmentName("Mechanical")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post( "/departments")
        .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "        \"departmentId\": 1,\n" +
                        "        \"departmentName\": \"IT-Support\",\n" +
                        "        \"departmentAddress\": \"Kolkatta\",\n" +
                        "        \"departmentCode\": \"Support-101\"\n" +
                        "    }"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }



    @Test
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get( "/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.departName")
                        .value(department.getDepartmentName()));
    }
}