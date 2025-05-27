package com.examen.zeuz.infrastructure.adapter.repository;

import com.examen.zeuz.domain.model.EmployeeModel;
import com.examen.zeuz.domain.ports.out.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class MySqlEmployeeRepository implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public boolean existsByNameAndLastName(String name, String lastName) {
        String sql = "SELECT COUNT(*) FROM employees WHERE name = ? AND last_name = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, name, lastName);
        return count != null && count > 0;
    }

    @Override
    public boolean genderExists(int genderId) {
        String sql = "SELECT COUNT(*) FROM genders WHERE id = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, genderId);
        return count != null && count > 0;
    }

    @Override
    public boolean jobExists(int jobId) {
        String sql = "SELECT COUNT(*) FROM jobs WHERE id = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, jobId);
        return count != null && count > 0;
    }

    @Override
    public Integer save(EmployeeModel employee) {
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_INSERT_EMPLOYEE(?, ?, ?, ?, ?, ?)}");
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getLastName());
            stmt.setDate(3, Date.valueOf(employee.getBirthdate()));
            stmt.setInt(4, employee.getGenderId());
            stmt.setInt(5, employee.getJobId());
            stmt.registerOutParameter(6, Types.INTEGER);
            stmt.execute();
            return stmt.getInt(6);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
