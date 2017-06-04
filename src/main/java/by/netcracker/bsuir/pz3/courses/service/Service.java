package by.netcracker.bsuir.pz3.courses.service;

import by.netcracker.bsuir.pz3.courses.exception.ServiceException;

import java.util.List;

public interface Service<T> {
    void add(T entity) throws ServiceException;
    T getById(int id) throws ServiceException;
    void update(T course) throws ServiceException;
    void delete(int id) throws ServiceException;

    List<T> getAll() throws ServiceException;
}
