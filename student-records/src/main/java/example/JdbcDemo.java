package example;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class JdbcDemo {
    // In-memory H2 database URL; DB_CLOSE_DELAY=-1 keeps the database alive until JVM exits
    static final String URL = "jdbc:h2:mem:school;DB_CLOSE_DELAY=-1";

    public static void main(String[] args) throws Exception {
        // 1. Establish connection using try-with-resources
        try (Connection con = DriverManager.getConnection(URL, "sa", "")) {
            System.out.println("Connected to H2 Database successfully!");

            // 2. Initialize schema and seed data from resources
            executeSqlFile(con, "/schema.sql");
            executeSqlFile(con, "/seed.sql");
            System.out.println("Database schema and seed data loaded!");

            // 3. Insert a new student safely using PreparedStatement
            String insertSql = "INSERT INTO students (name, email) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, "Asha"); // 1-based placeholder index
                ps.setString(2, "asha_new@example.test");
                int rowsInserted = ps.executeUpdate();
                System.out.println("Rows inserted: " + rowsInserted);

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("New Student Generated ID: " + generatedKeys.getLong(1));
                    }
                }
            }

            // 4. Query all students using SELECT
            String selectSql = "SELECT id, name, email FROM students";
            try (PreparedStatement ps = con.prepareStatement(selectSql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("\n--- Student Records in DB ---");
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    System.out.println("ID: " + id + " | Name: " + name + " | Email: " + email);
                }
            }
        }
    }

    // Helper method to read and run .sql resource files
    private static void executeSqlFile(Connection con, String resourcePath) throws Exception {
        try (InputStream is = JdbcDemo.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IllegalArgumentException("File not found: " + resourcePath);
            }
            String sql = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            try (Statement st = con.createStatement()) {
                for (String statement : sql.split(";")) {
                    if (!statement.trim().isEmpty()) {
                        st.execute(statement);
                    }
                }
            }
        }
    }
}