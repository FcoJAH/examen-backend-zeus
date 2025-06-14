package com.examen.zeuz.infrastructure.adapter.repository;

import com.examen.zeuz.domain.model.WorkedHoursModel;
import com.examen.zeuz.domain.ports.out.WorkedHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Types;
import java.time.LocalDate;

@Repository
public class MySqlWorkedHoursRepository implements WorkedHoursRepository {
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
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean workedDateExists(int employeeId, LocalDate workedDate) {
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_WORKED_DATE_EXISTS(?, ?, ?)}");
            stmt.setInt(1, employeeId);
            stmt.setDate(2, Date.valueOf(workedDate));
            stmt.registerOutParameter(3, Types.BOOLEAN);
            stmt.execute();
            return stmt.getBoolean(3);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer save(WorkedHoursModel wh) {
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_INSERT_WORKED_HOURS(?, ?, ?, ?)}");
            stmt.setInt(1, wh.getEmployeeId());
            stmt.setInt(2, wh.getWorkedHours());
            stmt.setDate(3, Date.valueOf(wh.getWorkedDate()));
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.execute();
            return stmt.getInt(4);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
