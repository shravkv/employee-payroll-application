package com.bridgelabz.employeepayrollapp.controller;


import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/home")
    public class EmployeeController {
        @Autowired
         IEmployeeService employeeService;

        @PostMapping("/addemployee")
        public EmployeeModel addEmployee(@RequestBody EmployeeDTO employeeDTO) {
            return employeeService.addEmployee(employeeDTO);
        }

        @GetMapping("/getallemployees")
        public List<EmployeeModel> getAllEmployeeData() throws EmployeeNotFoundException {
            return employeeService.getAllEmployeeData();
        }
}
