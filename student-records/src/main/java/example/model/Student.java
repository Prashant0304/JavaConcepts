package example.model;

public class Student {
    private Long id;
    private String name;
    private String email;

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Student(String name,String email){
        this(null,name,email);
    }

    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public String toString(){
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }

}
