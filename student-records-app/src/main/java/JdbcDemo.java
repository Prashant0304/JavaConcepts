import java.sql.SQLException;

public class JdbcDemo {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        try {
            System.out.println("--- Listing All Students ---");
            dao.listAll().forEach(System.out::println);

            System.out.println("\n--- Inserting New Student ---");
            long newId = dao.insert("Deepak", "deepak@example.test");
            System.out.println("Inserted student with ID: " + newId);

            System.out.println("\n--- Finding Student by ID ---");
            dao.findById(newId).ifPresent(System.out::println);

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
