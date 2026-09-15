package com.example.insurancereviewsupport;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbTest {

    private final JdbcTemplate jdbcTemplate;

    public DbTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void testQuery() {
        String sql = "SELECT EMP_NO, EMP_NAME FROM EMPLOYEES";

        jdbcTemplate.query(sql, (rs, rowNum) -> {
            System.out.println(
                    rs.getString("EMP_NO") + " / " +
                            rs.getString("EMP_NAME")
            );
            return null;
        });
    }
}