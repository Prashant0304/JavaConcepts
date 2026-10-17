package example.model;

public class Course {
    private Long id;
    private String title;
    private int capacity;


    public Course(Long id,String title,int capacity){
        this.id=id;
        this.title=title;
        this.capacity=capacity;
    }

    public Course(String title,int capacity){
        this(null,title,capacity);
    }
    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public int getCapacity(){
        return capacity;
    }

    @Override
    public String toString(){
        return "Course{id=" + id + ", title='" + title + "', capacity=" + capacity + "}";
    }
}
