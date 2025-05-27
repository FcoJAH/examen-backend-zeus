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
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_EMPLOYEE_NAME_EXISTS(?, ?, ?)}");
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.registerOutParameter(3, Types.BOOLEAN);
            stmt.execute();
            return stmt.getBoolean(3);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean genderExists(int genderId) {
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_GENDER_EXISTS(?, ?)}");
            stmt.setInt(1, genderId);
            stmt.registerOutParameter(2, Types.BOOLEAN);
            stmt.execute();
            return stmt.getBoolean(2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean jobExists(int jobId) {
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_JOB_EXISTS(?, ?)}");
            stmt.setInt(1, jobId);
            stmt.registerOutParameter(2, Types.BOOLEAN);
            stmt.execute();
            return stmt.getBoolean(2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
