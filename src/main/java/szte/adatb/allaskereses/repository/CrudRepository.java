package szte.adatb.allaskereses.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T find(int id);
    T save(T entity);
    T delete(int id);
    T delete(T entity);
}
