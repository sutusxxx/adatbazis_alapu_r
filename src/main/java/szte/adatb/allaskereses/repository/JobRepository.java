package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.Job;
import szte.adatb.allaskereses.model.JobDetails;
import szte.adatb.allaskereses.model.JobSeeker;

import javax.sql.DataSource;
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
        // Adja vissza az állásajánlatot a hozzá tartozó userhez
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
        // Jelenktezés állásajánlatra
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
