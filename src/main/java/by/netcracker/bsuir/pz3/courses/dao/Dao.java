package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.dao.exception.DaoException;

import java.util.List;

public interface Dao<T> {
    void add(T entity) throws DaoException;
    T getById(int id) throws DaoException;
    void update(T entity) throws DaoException;
    void delete(int id) throws DaoException;

    List<T> getAll() throws DaoException;
}
