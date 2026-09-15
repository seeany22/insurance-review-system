package com.example.insurancereviewsupport.Repository;

import com.example.insurancereviewsupport.Model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee findEmployeeNo(String empNo) {
        String sql = """
        SELECT EMP_NO, EMP_NAME, PASSWORD_HASH 
        FROM EMPLOYEES 
        WHERE EMP_NO= ?
        """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> {
                    Employee employee = new Employee();

                    employee.setEmpNo(rs.getString("EMP_NO"));
                    employee.setEmpName(rs.getString("EMP_NAME"));
                    employee.setPasswordHash(rs.getString("PASSWORD_HASH"));

                    return employee;
                },
                empNo
        );
    }
}