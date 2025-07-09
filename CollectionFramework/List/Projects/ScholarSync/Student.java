package CollectionFramework.List.Projects.ScholarSync;

public class Student {

    private int id;
    private String name;
    private int age;
    private String course;



    public Student(){}

    public Student( int id , String name , int age , String course ) {
        this.id = id;
        this.age= age;
        this.name = name;
        this.course = course;
    }


    public int getId( ) {
        return id;
    }

    public String getName( ) {
        return name;
    }

    public int getAge( ) {
        return age;
    }

    public String getCourse( ) {
        return course;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public void setCourse( String course ) {
        this.course = course;
    }

    @Override
    public String toString() {
        return STR."ID: \{id}, Name: \{name}, Age: \{age}, Course: \{course}";
    }

}
