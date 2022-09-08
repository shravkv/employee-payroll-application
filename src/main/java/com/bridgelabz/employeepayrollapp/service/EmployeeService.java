package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.CustomException;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeModel addEmployee(EmployeeDTO employeeDTO){
        EmployeeModel employee = new EmployeeModel(employeeDTO);
        return employeeRepository.save(employee);
    }

    public EmployeeModel updateEmployee(EmployeeDTO employeeDTO, int id){
        if(employeeRepository.existsById(id)) {
            EmployeeModel employee = employeeRepository.findById(id).get();
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employee);
        }  else {
            throw new CustomException("Employee Not found! id " + id);
        }

    }

    public String deleteEmployee(int id){
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Delete Successful";
        } else {
            throw new CustomException("Employee Table is Empty!");
        }

    }

    @Override
    public Optional<EmployeeModel> getEmployeeById(int id) {
        return Optional.empty();
    }

    public List<EmployeeModel> getEmployees() {
        if (!employeeRepository.findAll().isEmpty()) {
            return employeeRepository.findAll();
        } else throw new CustomException("Employee Table is Empty!");
    }


    public Optional<EmployeeModel> getEmployeeModelId(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            return employeeRepository.findById(id);
        } else {
            throw new CustomException("Employee is not found! id = " + id + " not found");
        }
    }

}