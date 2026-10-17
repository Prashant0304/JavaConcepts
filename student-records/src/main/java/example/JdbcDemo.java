package example;

import example.model.StudentEntity;
import java.util.List;

public class JdbcDemo {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();

        // Save a new record using Hibernate
        long newId = dao.insert("Test User", "test@example.com");
        System.out.println("Inserted Student with ID: " + newId);

        // Fetch all records
        List<StudentEntity> students = dao.listAll();
        for (StudentEntity s : students) {
            System.out.println("Student: " + s.getName() + " | " + s.getEmail());
        }
    }
}