package spring.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CarsDao {

    public void saveCars(Cars cars) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cars);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Cars> getCars() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Cars", Cars.class).list();
        }
    }

    public void updateCars(Cars employee) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
