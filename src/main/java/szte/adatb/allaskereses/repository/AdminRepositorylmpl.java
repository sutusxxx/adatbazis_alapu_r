package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.Admin;


import java.util.List;

@Repository
public class AdminRepositorylmpl implements AdminRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String SELECT_ALL = "SELECT * FROM adminok";

    public List<Admin> findAll() {
        List<Admin> result = jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> new Admin(
                        rs.getInt("adminID"),
                        rs.getString("felhasznalonev"),
                        rs.getString("jelszo")
                )
        );
        return result;
    }
}
