package CollectionFramework.List.Projects.ScholarSync;

public class Student {

    private String id;
    private String name;
    private int age;
    private String course;



    public Student(){}

    public Student( String id , String name , int age , String course ) {
        this.id = id;
        this.age= age;
        this.name = name;
        this.course = course;
    }


    public void setID( String id ) {
        this.id=id;
    }

    public void setName( String name ) {
        this.name=name;
    }

    public void setAge( int age ) {
        this.age=age;
    }

    public void setCourse( String course ) {
        this.course=course;
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

    @Override
    public String toString() {
        return "id: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }

    public String getId( ) {
        return getId ();
    }
}
