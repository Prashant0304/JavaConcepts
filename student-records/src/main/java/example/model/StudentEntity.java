package example.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="STUDENTS")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME" , nullable = false)
    private String name;

    @Column(name = "EMAIL" ,nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CourseEntity> courses =new ArrayList<>();


    public StudentEntity(){}

    public StudentEntity(String name,String email){
        this.name=name;
        this.email=email;
    }

    public void addCourse(CourseEntity course){
        courses.add(course);
        course.setStudent(this);
    }

    public void removeCourse(CourseEntity course){
        courses.remove(course);
        course.setStudent(null);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }
}
