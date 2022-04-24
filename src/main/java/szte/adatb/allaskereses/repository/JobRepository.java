package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.Job;
import szte.adatb.allaskereses.model.JobDetails;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JobRepository{
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public JobRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public static final String SELECT_ALL = "SELECT * FROM hirdetesek";

    public List<Job> findAll() {
        List<Job> result = jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> new Job(
                        rs.getInt("hirdetesID"),
                        rs.getString("cim"),
                        rs.getString("leiras"),
                        rs.getInt("hirdetoId"),
                        rs.getString("helyszin")
                )
        );
        return result;
    }

    public List<Job> findAllForUser(int userId) {
        return null;
    }

    public Job find(int id) {
        // Adja vissza az állásajánlatot a megfelelő ID-ra
        return null;
    }

    public JobDetails getJobDetails(int id) {
        // Adja vissza az állásajánlatot a cég nevével és az álláskereső adataival (Jobdetails mezők).
        return null;
    }

    public void applyJob(int jobId, int userId) {
        // PROCEDURE IN apply_for_job
        try {
            Connection conn = dataSource.getConnection();
            CallableStatement stmt = conn.prepareCall(
                    "{call apply_for_job(?, ?)}"
            );

            stmt.setInt(1, jobId);
            stmt.setInt(2, userId);

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Job save(Job entity) {
        // Új állásajánlat létrehozása
        return null;
    }

    public Job delete(int id, int userDd) {
        // Állásajánlat törlése, csak admin vagy az állásajánlathoz tartozó hirdető törlheti
        return null;
    }
}
