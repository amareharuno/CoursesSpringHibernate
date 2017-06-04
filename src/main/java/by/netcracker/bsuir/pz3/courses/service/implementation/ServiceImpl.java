package by.netcracker.bsuir.pz3.courses.service.implementation;

import by.netcracker.bsuir.pz3.courses.dao.Dao;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;
import by.netcracker.bsuir.pz3.courses.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl<T> implements Service<T>{

    @Autowired
    private Dao<T> dao;

    @Override
    public void add(T entity) throws ServiceException {
        try {
            dao.add(entity);
        } catch (DaoException exception) {
            throw new ServiceException("", exception);
        }
    }

    @Override
    public T getById(int id) throws ServiceException {
        T entity;
        try {
            entity = dao.getById(id);
        } catch (DaoException exception) {
            throw new ServiceException("", exception);
        }
        return entity;
    }

    @Override
    public void update(T entity) throws ServiceException {
        try {
            dao.update(entity);
        } catch (DaoException exception) {
            throw new ServiceException("", exception);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            dao.delete(id);
        } catch (DaoException exception) {
            throw new ServiceException("", exception);
        }
    }

    @Override
    public List<T> getAll() throws ServiceException {
        List<T> entities;
        try {
            entities = dao.getAll();
        } catch (DaoException exception) {
            throw new ServiceException("", exception);
        }
        return entities;
    }
}
