package com.examen.zeuz.infrastructure.adapter.repository;

import com.examen.zeuz.domain.ports.out.WorkedHoursSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;

@Repository
public class MySqlWorkedHoursSummaryRepository implements WorkedHoursSummaryRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public boolean employeeExists(int employeeId) {
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_EMPLOYEE_EXISTS(?, ?)}");
            stmt.setInt(1, employeeId);
            stmt.registerOutParameter(2, Types.BOOLEAN);
            stmt.execute();
            return stmt.getBoolean(2);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer getTotalWorkedHours(int employeeId, LocalDate startDate, LocalDate endDate) {
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_TOTAL_HOURS_BY_DATE(?, ?, ?, ?)}");
            stmt.setInt(1, employeeId);
            stmt.setDate(2, Date.valueOf(startDate));
            stmt.setDate(3, Date.valueOf(endDate));
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.execute();
            return stmt.getInt(4);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
