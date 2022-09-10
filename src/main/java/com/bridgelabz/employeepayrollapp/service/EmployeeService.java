package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.email.EmailService;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.exception.CustomException;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    EmailService emailService;

    public EmployeeModel addEmployee(EmployeeDTO employeeDTO){
        EmployeeModel employee = new EmployeeModel(employeeDTO);
        emailService.sendEmail(employeeDTO.getEmail(),"Employee added","Hello "+employeeDTO.getName()+" your employee record was added successfully");
        return  employeeRepository.save(employee);
    }


    public EmployeeModel updateEmployee(EmployeeDTO employeeDTO,int id){
        if(employeeRepository.findById(id).isPresent()) {
        EmployeeModel employee = employeeRepository.findById(id).get();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return  employeeRepository.save(employee);
    }
    else {
            throw new CustomException("Employee by ID " + id + " is not present");
        }
    }

    public String deleteEmployee(int id){
        if(employeeRepository.findById(id).isPresent()) {
        employeeRepository.deleteById(id);
        return "Delete SuccessFull";
        }
        else
            throw new CustomException("Employee by ID "+id+" is not present");
        }

    public Optional<EmployeeModel> getEmployeeById(int id){
        if(employeeRepository.findById(id).isPresent()) {
        return employeeRepository.findById(id);
        }
        else
            throw new CustomException("Employee by ID "+id+" is not present");
        }

    public List<EmployeeModel> getEmployees() {
        if(!employeeRepository.findAll().isEmpty()){
        return employeeRepository.findAll();
        }
        else
            throw new CustomException("No employee in database to display");
        }
}