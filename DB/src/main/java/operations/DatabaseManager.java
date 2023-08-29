package operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class DatabaseManager {
    private final SessionFactory sessionFactory;

    public DatabaseManager() {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata.getSessionFactoryBuilder()
                .build();
    }

    public <T> void addToDatabase(T entity) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction;
            transaction = session.beginTransaction();

            if (entity instanceof List) {
                List<T> entityList = (List<T>) entity;
                for (T item : entityList) {
                    session.merge(item);
                }
            } else {
                session.merge(entity);
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Failed to add to database!");
        }
    }

    public <T> T getFromDatabaseById(Class<T> entityClass, Serializable id) {
        Session session = sessionFactory.openSession();
        T result = null;

        try {
            result = session.get(entityClass, id);
        } catch (Exception e) {
            System.out.println("Object not found in the database.");
        } finally {
            session.close();
        }
        return result;
    }

    public <T> T getFromDatabaseByRevision(Class<T> entityClass, Serializable id, Number revision) {
        Session session = sessionFactory.openSession();
        T result = null;

        try {
            AuditReader auditReader = AuditReaderFactory.get(session);
            result = auditReader.find(entityClass, id, revision);
        } catch (Exception e) {
            System.out.println("Object not found in the database.");
        } finally {
            session.close();
        }

        return result;
    }

    public <T> void setFieldValue(Class<T> entityClass, int index, String fieldName, Object newValue) {

        Transaction transaction;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            List<T> resultList = session.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
            if (!resultList.isEmpty()) {
                T firstItem = resultList.get(index - 1);
                Class<?> clazz = firstItem.getClass();
                Field field = clazz.getDeclaredField(fieldName);

                field.setAccessible(true);
                field.set(firstItem, newValue);
                session.merge(firstItem);
            }

            transaction.commit();
            System.out.println("Field value of the first item updated and committed to the database.");
        } catch (Exception e) {
            System.out.println("Failed to update value of field!");
        }
    }
}

