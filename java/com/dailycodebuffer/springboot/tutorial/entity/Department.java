package com.dailycodebuffer.springboot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity// To make this class as an entity to make it to interact with DB using JPA

@Data // from lombok to remove getter and setter and to string
@NoArgsConstructor // for default constructor
@AllArgsConstructor // for all args constructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please add department name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
