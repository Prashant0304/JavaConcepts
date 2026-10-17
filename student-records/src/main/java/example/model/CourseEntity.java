package example.model;

import javax.persistence.*;

@Entity
@Table(name="courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name",nullable = false)
    private String courseName;

    @Column(name = "course_code",nullable = false)
    private String courseCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",nullable = false)
    private StudentEntity student;

    public CourseEntity(){}

    public CourseEntity(String courseCode, String courseName, StudentEntity student) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.student = student;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public StudentEntity getStudent() {
        return student;
    }
}
