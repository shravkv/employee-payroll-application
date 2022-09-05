package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    EmployeeModel addEmployee(EmployeeDTO employeeDTO);
    EmployeeModel updateEmployee(EmployeeDTO employeeDTO,int id);
    String deleteEmployee(int id);
    Optional<EmployeeModel> getEmployeeById(int id);
    List<EmployeeModel> getEmployees();
}
