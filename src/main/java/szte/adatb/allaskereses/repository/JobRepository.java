package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.Job;
import szte.adatb.allaskereses.model.JobDetails;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
public class JobRepository{
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    private final String SELECT_JOB_DETAILS = "SELECT hirdetesID, cim, leiras, helyszin, hirdetok.nev AS hirdeto_nev, email, " +
            "hirdetok.telefon AS hirdeto_telefon, cegek.nev AS ceg_nev FROM hirdetesek INNER JOIN hirdetok ON hirdetesek.hirdetoID = hirdetok.hirdetoID " +
            "INNER JOIN cegek ON cegek.cegID = hirdetok.cegID WHERE hirdetesID = ?";

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
        JobDetails jd = null;
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(SELECT_JOB_DETAILS);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                jd = new JobDetails(
                        rs.getInt("hirdetesID"),
                        rs.getString("cim"),
                        rs.getString("leiras"),
                        rs.getString("helyszin"),
                        rs.getString("ceg_nev"),
                        rs.getString("hirdeto_nev"),
                        rs.getString("email"),
                        rs.getString("hirdeto_telefon")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jd;
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
