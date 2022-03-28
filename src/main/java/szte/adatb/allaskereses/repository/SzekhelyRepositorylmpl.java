package szte.adatb.allaskereses.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.Szekhely;

import java.util.List;

@Repository
public class SzekhelyRepositorylmpl implements SzekhelyRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String SELECT_ALL = "SELECT * FROM szekhelyek";

    public List<Szekhely> findAll() {
        List<Szekhely> result = jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> new Szekhely(
                        rs.getInt("szekhelyID"),
                        rs.getString("megye"),
                        rs.getString("varos"),
                        rs.getString("utca"),
                        rs.getInt("hazszam"),
                        rs.getInt("irsz")
                )
        );
        return result;
    }
}
