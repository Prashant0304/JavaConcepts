package example;

import example.model.CourseEntity;
import example.model.StudentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RelationshipDemo {
    public static void main(String[] args) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // 1. Create a new Student
            StudentEntity student = new StudentEntity("Ananya Gupta", "ananya@example.com");

            // 2. Create Courses and link them using our helper method
            CourseEntity course1 = new CourseEntity("Database Design", "CS101", student);
            CourseEntity course2 = new CourseEntity("Enterprise Java", "CS102", student);

            student.getCourses().add(course1);
            student.getCourses().add(course2);

            // 3. Save the Student (Hibernate will cascade and save the courses automatically!)
            session.save(student);

            transaction.commit();
            System.out.println("Successfully saved Student with ID: " + student.getId() + " and their courses!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        // Shutdown Hibernate Session Factory
        HibernateUtil.shutdown();
    }
}