package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;


@Entity
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public int id;
    public String name;
    public String gender;
    @ElementCollection
    @CollectionTable(name = "department", joinColumns = @JoinColumn(name = "id"))
    private List<String> department;
    public int salary;
    public LocalDate startDate;
    public String notes;

    public String email;
    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeModel(int id, String name, String gender, int salary, LocalDate startDate, String notes, List<String> department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
        this.notes = notes;
        this.department = department;
    }

    public EmployeeModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public EmployeeModel(EmployeeDTO employeeDTO, String gender, LocalDate startDate, String notes){
        this.name = employeeDTO.getName();
        this.department = employeeDTO.getDepartment();
        this.salary = employeeDTO.getSalary();
        this.gender = gender;
        this.startDate = startDate;
        this.notes = notes;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public EmployeeModel(EmployeeDTO employeeDTO){
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.notes = employeeDTO.getNotes();
        this.email = employeeDTO.getEmail();
        this.startDate = employeeDTO.getStartDate();
        this.department = employeeDTO.getDepartment();
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
