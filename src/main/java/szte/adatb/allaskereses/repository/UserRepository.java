package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository implements CrudRepository<User> {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
    }

    public static final String SELECT_ALL = "SELECT * FROM allaskeresok";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM allaskeresok WHERE allaskeresoID=?";
    public static final String SELECT_USER_BY_NAME = "SELECT * FROM allaskeresok WHERE felhasznalonev=?";

    @Override
    public List<User> findAll() {

        List<User> result = jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> new User(
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

    @Override
    public User find(int id) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
        ) {
            ps.setInt(1, id);
            return getUserByQuery(ps);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findByUsername(String username) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_NAME);
        ) {
            ps.setString(1, username);
            return getUserByQuery(ps);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User getUserByQuery(PreparedStatement ps) throws SQLException {
        User result = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            result = new User(
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

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User delete(int id) {
        return null;
    }

    @Override
    public User delete(User entity) {
        return null;
    }
}
