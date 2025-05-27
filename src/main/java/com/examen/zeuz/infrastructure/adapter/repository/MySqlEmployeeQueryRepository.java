package com.examen.zeuz.infrastructure.adapter.repository;

import com.examen.zeuz.domain.model.EmployeeWithDetailsModel;
import com.examen.zeuz.domain.model.GenderModel;
import com.examen.zeuz.domain.model.JobModel;
import com.examen.zeuz.domain.ports.out.EmployeeQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MySqlEmployeeQueryRepository implements EmployeeQueryRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public boolean jobExists(int jobId) {
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_JOB_EXISTS(?, ?)}");
            stmt.setInt(1, jobId);
            stmt.registerOutParameter(2, Types.BOOLEAN);
            stmt.execute();
            return stmt.getBoolean(2);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EmployeeWithDetailsModel> findByJobId(int jobId) {
        List<EmployeeWithDetailsModel> result = new ArrayList<>();
        try (Connection conn = jdbc.getDataSource().getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL ZEUS_GET_EMPLOYEES_BY_JOB(?)}");
            stmt.setInt(1, jobId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.add(mapRow(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private EmployeeWithDetailsModel mapRow(ResultSet rs) throws SQLException {
        return new EmployeeWithDetailsModel(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("last_name"),
                rs.getDate("birthdate").toLocalDate(),
                new JobModel(
                        rs.getInt("job_id"),
                        rs.getString("job_name"),
                        rs.getBigDecimal("salary")
                ),
                new GenderModel(
                        rs.getInt("gender_id"),
                        rs.getString("gender_name")
                )
        );
    }

}
