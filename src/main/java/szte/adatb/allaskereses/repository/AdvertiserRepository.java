package szte.adatb.allaskereses.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.Advertiser;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AdvertiserRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public AdvertiserRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public List<Advertiser> findAll() {
        return null;
    }

    public Advertiser find(int id) {
        return null;
    }

    public Advertiser save(Advertiser entity) {
        return null;
    }

    public Advertiser delete(int id) {
        return null;
    }

    public Advertiser delete(Advertiser entity) {
        return null;
    }
}
