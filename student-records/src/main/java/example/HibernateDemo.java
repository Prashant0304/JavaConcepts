package example;

import example.model.StudentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDemo {
    public static void main(String[] args) {
        // 1. Create a new Student object
        StudentEntity student = new StudentEntity("Vikram Singh", "vikram@example.test");

        // 2. Open a session and start a transaction
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            // Save object to database (Hibernate generates the INSERT SQL)
            session.save(student);
            tx.commit();

            System.out.println("Saved Student ID: " + student.getId());

            // Retrieve object by ID (Hibernate generates the SELECT SQL)
            StudentEntity retrieved = session.get(StudentEntity.class, student.getId());
            System.out.println("Retrieved Student: " + retrieved.getName() + " | " + retrieved.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}