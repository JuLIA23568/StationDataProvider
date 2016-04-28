package by.bsuir.station.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class AbstractDAO<T> {

    @Autowired private SessionFactory sessionFactory;

    public T save(T object) {
        getCurrentSession().save(object);
        return object;
    }

    public T update(T object) {
        getCurrentSession().update(object);
        return object;
    }

    public T delete(T object) {
        getCurrentSession().delete(object);
        return object;
    }

    public List<T> select(Class clazz) {
        return getCurrentSession().createCriteria(clazz).list();
    }

    public T select(Class clazz, Serializable id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Query customSelect(String queryString, Object... params) {
        Query query = getCurrentSession().createQuery(queryString);

        for(int i=0; i<params.length; i++) {
            query.setParameter(i, params[i]);
        }

        return query;
    }
}
