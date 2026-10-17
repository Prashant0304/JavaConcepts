package example;

import example.model.StudentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class StudentDao {

    public StudentDao() {
        // Default constructor for Hibernate DAO
    }

    // CREATE: Insert a new student record
    public long insert(String name, String email) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            StudentEntity student = new StudentEntity(name, email);
            session.save(student); // Saves object and populates generated ID

            tx.commit();
            return student.getId();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
    }

    // READ: Find student by primary key ID
    public Optional<StudentEntity> findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StudentEntity student = session.get(StudentEntity.class, id);
            return Optional.ofNullable(student);
        }
    }

    // READ: Get list of all students using HQL
    public List<StudentEntity> listAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM StudentEntity", StudentEntity.class).list();
        }
    }

    // UPDATE: Modify student email by ID
    public boolean updateEmail(long id, String newEmail) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            StudentEntity student = session.get(StudentEntity.class, id);
            if (student != null) {
                student.setEmail(newEmail);
                session.update(student);
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
    }

    // DELETE: Delete student record by ID
    public boolean deleteById(long id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            StudentEntity student = session.get(StudentEntity.class, id);
            if (student != null) {
                session.delete(student);
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
    }
}