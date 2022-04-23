package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.JobSeeker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JobSeekerRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public JobSeekerRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public static final String SELECT_ALL = "SELECT * FROM allaskeresok";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM allaskeresok WHERE allaskeresoID=?";
    public static final String SELECT_USER_BY_NAME = "SELECT * FROM allaskeresok WHERE felhasznalonev=?";

    public List<JobSeeker> findAll() {

        List<JobSeeker> result = jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> new JobSeeker(
                rs.getInt("allaskeresoID"),
                rs.getString("felhasznalonev"),
                rs.getString("jelszo"),
                rs.getString("nev"),
                rs.getString("vegzettseg"),
                rs.getDate("szuldatum"),
                rs.getString("nyelvismeret"),
                rs.getString("email"),
                rs.getString("lakhely"),
                rs.getString("telefon")
            )
        );
        return result;
    }

    public JobSeeker find(int id) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
        ) {
            ps.setInt(1, id);
            return getUserByQuery(ps);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public JobSeeker findByUsername(String username) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_NAME);
        ) {
            ps.setString(1, username);
            return getUserByQuery(ps);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private JobSeeker getUserByQuery(PreparedStatement ps) throws SQLException {
        JobSeeker result = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            result = new JobSeeker(
                    rs.getInt("allaskeresoID"),
                    rs.getString("felhasznalonev"),
                    rs.getString("jelszo"),
                    rs.getString("nev"),
                    rs.getString("vegzettseg"),
                    rs.getDate("szuldatum"),
                    rs.getString("nyelvismeret"),
                    rs.getString("email"),
                    rs.getString("lakhely"),
                    rs.getString("telefon")
            );
        }
        return result;
    }

    public JobSeeker save(JobSeeker entity) {
        return null;
    }

    public JobSeeker delete(int id) {
        return null;
    }

    public JobSeeker delete(JobSeeker entity) {
        return null;
    }
}
