package by.netcracker.bsuir.pz3.courses.dao.exception;

import org.hibernate.HibernateException;

public class DaoException extends HibernateException{
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
