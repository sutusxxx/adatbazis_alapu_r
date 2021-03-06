package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.*;
import szte.adatb.allaskereses.model.job.CreateJob;
import szte.adatb.allaskereses.model.job.Job;
import szte.adatb.allaskereses.model.job.JobDetails;
import szte.adatb.allaskereses.model.job.UpdateJob;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepository{
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    private final String SELECT_JOBS_FOR_ADVERTISER = "SELECT * FROM hirdetesek WHERE hirdetoID = ?";
    private final String SELECT_JOB = "SELECT * FROM hirdetesek WHERE hirdetesID = ?";
    private final String SELECT_JOB_DETAILS = "SELECT hirdetesID, cim, leiras, helyszin, hirdetok.nev AS hirdeto_nev, email, " +
            "hirdetok.telefon AS hirdeto_telefon, cegek.nev AS ceg_nev, hirdetok.hirdetoID AS hirdeto FROM hirdetesek INNER JOIN hirdetok ON hirdetesek.hirdetoID = hirdetok.hirdetoID " +
            "INNER JOIN cegek ON cegek.cegID = hirdetok.cegID WHERE hirdetesID = ?";
    private final String SELECT_WORK_TYPES = "SELECT munka_jellege.megnevezes AS munka FROM munka_jellege INNER JOIN hirdetes_jellege ON munka_jellege.munkaID = hirdetes_jellege.munkaID WHERE hirdetes_jellege.hirdetesID = ?";

    @Autowired
    public JobRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    private final String SELECT_ALL = "SELECT * FROM hirdetesek";
    private final String DELETE_JOB = "DELETE FROM hirdetesek WHERE hirdetesId = ?";

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
        List<Job> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_JOBS_FOR_ADVERTISER)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Job job = new Job(
                        rs.getInt("hirdetesID"),
                        rs.getString("cim"),
                        rs.getString("leiras"),
                        rs.getInt("hirdetoID"),
                        rs.getString("helyszin")
                );
                result.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Job find(int id) {
        // Adja vissza az ??ll??saj??nlatot a megfelel?? ID-ra
        return null;
    }

    public Job getJob(int id) {
        Job job = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_JOB)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                job = new Job(
                        rs.getInt("hirdetesID"),
                        rs.getString("cim"),
                        rs.getString("leiras"),
                        rs.getInt("hirdetoID"),
                        rs.getString("helyszin")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return job;
    }

    public JobDetails getJobDetails(int id) {
        // Adja vissza az ??ll??saj??nlatot a c??g nev??vel ??s az ??ll??skeres?? adataival (Jobdetails mez??k).
        JobDetails jd = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_JOB_DETAILS)) {

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
                        rs.getString("hirdeto_telefon"),
                        rs.getInt("hirdeto"),
                        null
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jd;
    }

    public List<String> getWorkTypesForJob(int id) {
        List<String> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_WORK_TYPES)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.add(rs.getString("munka"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean applyJob(int jobId, int userId) {
        // PROCEDURE IN apply_for_job
        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall(
                     "{call apply_for_job(?, ?)}"
             )){
            stmt.setInt(1, jobId);
            stmt.setInt(2, userId);

            stmt.execute();
            System.out.println("applyJob sql success");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean create(CreateJob entity) {
        // PROCEDURE IN create_job
        try(Connection conn = dataSource.getConnection();
            CallableStatement stmt = conn.prepareCall("{call create_job(?, ?, ?, ?)}")) {
            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getDescription());
            stmt.setInt(3, entity.getAdvertiserId());
            stmt.setString(4, entity.getPlace());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean create(CreateCV entity) {
        // PROCEDURE IN create_cv
        try(Connection conn = dataSource.getConnection();
            CallableStatement stmt = conn.prepareCall("{call create_cv(?, ?, ?, ?)}")) {
            stmt.setString(1, entity.getIntroduction());
            stmt.setString(2, entity.getExperience());
            stmt.setString(3, entity.getMotivation());
            stmt.setInt(4, entity.getJobSeekerId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(UpdateJob entity) {
        return false;
    }

    public boolean delete(int jobId, int userId) {
        // FUNCTION IN can_delete_job
        try (Connection conn = dataSource.getConnection()) {
//            CallableStatement stmt = conn.prepareCall(
//                    "{call ? = can_delete_job(?, ?)}"
//            );
//            stmt.registerOutParameter(1, Types.INTEGER);
//            stmt.setInt(2, jobId);
//            stmt.setInt(3, userId);

//            stmt.execute();
//            int bool = stmt.getInt(1);
            int bool = 1;
            if (bool == 1) {
                System.out.printf("Delete job with id: " + jobId);
                PreparedStatement ps = conn.prepareStatement(DELETE_JOB);
                ps.setInt(1, jobId);
                ps.execute();
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
