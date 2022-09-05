package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeModel addEmployee(EmployeeDTO employeeDTO){
        EmployeeModel employee = new EmployeeModel(employeeDTO);
        return  employeeRepository.save(employee);
    }

    public EmployeeModel updateEmployee(EmployeeDTO employeeDTO,int id){
        EmployeeModel employee = employeeRepository.findById(id).get();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return  employeeRepository.save(employee);
    }

    public String deleteEmployee(int id){
        employeeRepository.deleteById(id);
        return "Delete SuccessFull";
    }

    public Optional<EmployeeModel> getEmployeeById(int id){
        return employeeRepository.findById(id);
    }

    public List<EmployeeModel> getEmployees() {
        return employeeRepository.findAll();
    }
}