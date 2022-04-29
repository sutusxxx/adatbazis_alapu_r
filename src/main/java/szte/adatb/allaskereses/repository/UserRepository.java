package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.Company;
import szte.adatb.allaskereses.model.Headquarters;
import szte.adatb.allaskereses.model.user.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    private final String SELECT_ALL_JS = "SELECT * FROM allaskeresok";
    private final String SELECT_APPLICATIONS_FOR_USER = "SELECT cim, hirdetesek.hirdetesID FROM hirdetesek " +
            "INNER JOIN jelentkezesek ON hirdetesek.hirdetesId = jelentkezesek.hirdetesId WHERE jelentkezesek.allaskeresoID = ?";
    private final String SELECT_ALL_AT = "SELECT * FROM hirdetok";
    private final String SELECT_USER_BY_ID = "SELECT * FROM allaskeresok WHERE allaskeresoID=?";
    private final String SELECT_COMPANY_FOR_ADVERTISER = "SELECT * FROM cegek INNER JOIN szekhelyek ON cegek.szekhelyID = " +
            "szekhelyek.szekhelyID WHERE cegID = (SELECT cegID FROM " +
            "hirdetok WHERE hirdetoID = ?)";
    private final String SELECT_ADVERTISER_BY_ID = "SELECT * FROM hirdetok WHERE hirdetoID = ?";
    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public List<JobSeeker> findAllJS() {
        List<JobSeeker> list = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement()) {

            ResultSet rs = statement.executeQuery(SELECT_ALL_JS);
            while (rs.next()) {
                JobSeeker js = new JobSeeker(
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
                list.add(js);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Advertiser> findAllAT() {
        List<Advertiser> list = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement()) {

            ResultSet rs = statement.executeQuery(SELECT_ALL_AT);
            while (rs.next()) {
                Advertiser at = new Advertiser(
                        rs.getInt("hirdetoID"),
                        rs.getString("felhasznalonev"),
                        rs.getString("jelszo"),
                        rs.getString("email"),
                        rs.getString("telefon"),
                        rs.getString("nev"),
                        null
                );
                list.add(at);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public JobSeeker findJobSeeker(int id) {
        JobSeeker result = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Advertiser findAdvertiser(int id) {
        Advertiser result = null;
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SELECT_COMPANY_FOR_ADVERTISER);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Headquarters hq = new Headquarters(
                        rs.getInt("SzekhelyID"),
                        rs.getString("megye"),
                        rs.getString("varos"),
                        rs.getString("utca"),
                        rs.getInt("hazszam"),
                        rs.getInt("irsz")
                );
                Company company = new Company(
                        rs.getInt("cegID"),
                        rs.getString("nev"),
                        rs.getString("telefon"),
                        null,
                        hq
                );
                ps = conn.prepareStatement(SELECT_ADVERTISER_BY_ID);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    result = new Advertiser(
                            rs.getInt("hirdetoID"),
                            rs.getString("felhasznalonev"),
                            rs.getString("jelszo"),
                            rs.getString("email"),
                            rs.getString("telefon"),
                            rs.getString("nev"),
                            company
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Map<String, String> findApplicationsForUser(int userId) {
        Map<String, String> result = new HashMap<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_APPLICATIONS_FOR_USER)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.put(rs.getString("hirdetesID"), rs.getString("cim"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteApplication(int userId, int jobId) {
        return false;
    }

    public JobSeeker loginJobSeeker(LoginForm loginForm) {
        JobSeeker result = null;
        List<JobSeeker> list = findAllJS();
        for (JobSeeker js : list) {
            if (js.getUsername().equals(loginForm.username) && js.getPassword().equals(loginForm.password)) {
                result = js;
                System.out.println(loginForm.username);
                System.out.println(loginForm.password);
            }
        }
        return result;
    }

    public Advertiser loginAdvertiser(LoginForm loginForm) {
        Advertiser result = null;
        List<Advertiser> list = findAllAT();
        for (Advertiser at : list) {
            if (at.getUsername().equals(loginForm.username) && at.getPassword().equals(loginForm.password)) {
                result = at;
                System.out.println(at);
            }
        }
        return result;
    }

    public boolean createJobSeeker(CreateJobSeeker jobSeeker) {
        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall("{call allaskereso_create(?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {
            stmt.setString(1, jobSeeker.getUsername());
            stmt.setString(2, jobSeeker.getPassword());
            stmt.setString(3, jobSeeker.getName());
            stmt.setString(4, jobSeeker.getEducation());
            stmt.setDate(5, new Date(jobSeeker.getDateOfBirth().getTime()));
            stmt.setString(6, jobSeeker.getLanguage());
            stmt.setString(7, jobSeeker.getEmail());
            stmt.setString(8, jobSeeker.getAddress());
            stmt.setString(9, jobSeeker.getPhone());

            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createAdvertiser(CreateAdvertiser advertiser) {
        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall("{call hirdeto_create(?, ?, ?, ?, ?, ?)}")) {
            stmt.setString(1, advertiser.getUsername());
            stmt.setString(2, advertiser.getPassword());
            stmt.setString(3, advertiser.getEmail());
            stmt.setString(5, advertiser.getName());
            stmt.setString(4, advertiser.getPhone());
            stmt.setInt(6,1);

            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Advertiser getAdvertiser(int id) {
        // Adja vissza a hirdető adatait id alapján.
        return null;
    }

    public Admin getAdmin(int id) {
        // Adja vissza az admin adatait id alapján.
        return null;
    }
}
