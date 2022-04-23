package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.Admin;
import szte.adatb.allaskereses.model.Advertiser;
import szte.adatb.allaskereses.model.JobSeeker;
import szte.adatb.allaskereses.model.LoginForm;

import javax.sql.DataSource;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public int loginUser(LoginForm loginForm, String type) {
        if (type.equals("admin")) {
            // Keressen rá az adott táblában a felhasználónév és jelszóra és nézze meg hogy van-e egyezés
        }
        if (type.equals("allaskereso")) {
            // Keressen rá az adott táblában a felhasználónév és jelszóra és nézze meg hogy van-e egyezés
        }
        if (type.equals("hirdeto")) {
            // Keressen rá az adott táblában a felhasználónév és jelszóra és nézze meg hogy van-e egyezés
        }
        // Ha van egyezés akkor az id-val térjen vissza
        return -1;
    }

    public JobSeeker getJobSeeker(int id) {
        // Adja vissza az álláskereső adatait id alapján.
        return null;
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
