package com.example.insurancereviewsupport.Service;

import com.example.insurancereviewsupport.Model.Employee;
import com.example.insurancereviewsupport.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final EmployeeRepository employeeRepository;

    public LoginService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public boolean login(String empNo, String passwordHash) {
        Employee employee = employeeRepository.findEmployeeNo(empNo);
        return passwordHash.equals(employee.getPasswordHash());

    }

    public Employee findEmployee(String empNo) {
        return employeeRepository.findEmployeeNo(empNo);
    }
}
