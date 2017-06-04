package by.netcracker.bsuir.pz3.courses.service.implementation;

import by.netcracker.bsuir.pz3.courses.dao.Dao;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;
import by.netcracker.bsuir.pz3.courses.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceImpl<T> implements Service<T>{

    @Autowired
    private Dao<T> dao;

    public ServiceImpl(Dao<T> dao) {
        this.dao = dao;
    }

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
        return null;
    }

    @Override
    public void update(T entity) throws ServiceException {

    }

    @Override
    public void delete(int id) throws ServiceException {

    }

    @Override
    public List<T> getAll() throws ServiceException {
        return null;
    }
}
