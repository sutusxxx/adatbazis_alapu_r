package szte.adatb.allaskereses.repository;

import org.springframework.stereotype.Repository;
import szte.adatb.allaskereses.model.Job;

import java.util.List;

@Repository
public class JobRepository implements CrudRepository<Job> {

    @Override
    public List<Job> findAll() {
        return null;
    }

    @Override
    public Job find(int id) {
        return null;
    }

    @Override
    public Job save(Job entity) {
        return null;
    }

    @Override
    public Job delete(int id) {
        return null;
    }

    @Override
    public Job delete(Job entity) {
        return null;
    }
}
