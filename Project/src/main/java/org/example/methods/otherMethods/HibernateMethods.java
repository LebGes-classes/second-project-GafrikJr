package org.example.methods.otherMethods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.function.Consumer;

public class HibernateMethods {

    public static <T> T getObjectById(int id, Class<T> objectClass) {
        Configuration configuration = new Configuration().addAnnotatedClass(objectClass);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            T item = session.get(objectClass, id);
            session.getTransaction().commit();
            return item;
        } finally {
            sessionFactory.close();
        }
    }

    public static <T> void deleteObjectById(int id, Class<T> objectClass) {
        Configuration configuration = new Configuration().addAnnotatedClass(objectClass);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            T item = session.get(objectClass, id);
            session.delete(item);
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }

    public static <T> List<T> getObjectsByRequest(Class<T> objectClass, String request) {
        Configuration configuration = new Configuration().addAnnotatedClass(objectClass);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            List<T> items = session.createQuery(request).getResultList();
            session.getTransaction().commit();
            return items;
        }
        finally  {
            sessionFactory.close();
        }
    }

    public static <T> void createEntry(T item, Class<T> objectClass) {
        Configuration configuration = new Configuration().addAnnotatedClass(objectClass);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    public static <T> void updateEntity(int id, Class<T> objectClass, Consumer<T> updater) {
        Configuration configuration = new Configuration().addAnnotatedClass(objectClass);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            T entity = session.get(objectClass, id);
            updater.accept(entity);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

}
