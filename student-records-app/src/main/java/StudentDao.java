import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class StudentDao {

    private static final String URL = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Login";


    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public long insert(String name, String email) throws SQLException{
        String sql="INSERT INTO students(name,email) VALUES (?,?)";
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,name);
            ps.setString(2,email);
            ps.executeUpdate();

            try(ResultSet rs=ps.getGeneratedKeys()){
                if(rs.next()){
                    return rs.getLong(1);
                }
            }
        }
        return -1;
    }


    public Optional<Student> findById(long id) throws SQLException {
        String sql = "SELECT id, name, email FROM students WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Student(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("email")
                    ));
                }
            }
        }
        return Optional.empty();
    }

    public List<Student> listAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, name, email FROM students";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }
        }
        return students;
    }

}
