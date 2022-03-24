package szte.adatb.allaskereses.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.Model.Allaskereso;

import java.util.List;

@Repository
public class AllaskeresoRepositoryImpl implements AllaskeresoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String SELECT_ALL = "SELECT * FROM allaskeresok";

    public List<Allaskereso> findAll() {
        List<Allaskereso> result = jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> new Allaskereso(
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
}
