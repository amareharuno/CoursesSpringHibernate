package by.netcracker.bsuir.pz3.courses.service.implementation;

import by.netcracker.bsuir.pz3.courses.dao.Dao;
import by.netcracker.bsuir.pz3.courses.dao.exception.DaoException;
import by.netcracker.bsuir.pz3.courses.service.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.service.Service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public abstract class ServiceImpl<T> implements Service<T>{

    private Logger logger = LogManager.getLogger(ServiceImpl.class);

    @Autowired
    private Dao<T> dao;

    @Transactional
    @Override
    public void add(T entity) throws ServiceException {
        logger.info(LoggingAndExceptionMessage.SERVICE_ADD);
        try {
            dao.add(entity);
            logger.info(LoggingAndExceptionMessage.ADD_OK);
        } catch (DaoException exception) {
            logger.error(LoggingAndExceptionMessage.ADD_FAIL);
            throw new ServiceException(LoggingAndExceptionMessage.ADD_FAIL, exception);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public T getById(int id) throws ServiceException {
        logger.info(LoggingAndExceptionMessage.SERVICE_GET);
        try {
            T entity = dao.getById(id);
            logger.info(LoggingAndExceptionMessage.GET_OK);
            return entity;
        } catch (DaoException exception) {
            logger.error(LoggingAndExceptionMessage.GET_FAIL);
            throw new ServiceException(LoggingAndExceptionMessage.GET_FAIL, exception);
        }
    }

    @Transactional
    @Override
    public void update(T entity) throws ServiceException {
        logger.info(LoggingAndExceptionMessage.SERVICE_UPDATE);
        try {
            dao.update(entity);
            logger.info(LoggingAndExceptionMessage.UPDATE_OK);
        } catch (DaoException exception) {
            logger.error(LoggingAndExceptionMessage.UPDATE_FAIL);
            throw new ServiceException(LoggingAndExceptionMessage.UPDATE_FAIL, exception);
        }
    }

    @Transactional
    @Override
    public void delete(int id) throws ServiceException {
        logger.info(LoggingAndExceptionMessage.SERVICE_DELETE);
        try {
            dao.delete(id);
            logger.info(LoggingAndExceptionMessage.DELETE_OK);
        } catch (DaoException exception) {
            logger.info(LoggingAndExceptionMessage.DELETE_FAIL);
            throw new ServiceException(LoggingAndExceptionMessage.DELETE_FAIL, exception);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> getAll() throws ServiceException {
        logger.info(LoggingAndExceptionMessage.SERVICE_GET_ALL);
        try {
            List<T> entities = dao.getAll();
            logger.info(LoggingAndExceptionMessage.GET_ALL_OK);
            return entities;
        } catch (DaoException exception) {
            logger.info(LoggingAndExceptionMessage.GET_ALL_FAIL);
            throw new ServiceException("", exception);
        }
    }
}
