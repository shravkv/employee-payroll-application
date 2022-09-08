package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component

public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$",message = "Not a Valid Name")
    private String name;
    private int salary;
    private String gender;
    private String notes;
    private LocalDate startDate;
    private List<String> department;


}
