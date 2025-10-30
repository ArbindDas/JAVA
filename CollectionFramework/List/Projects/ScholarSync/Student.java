package CollectionFramework.List.Projects.ScholarSync;

sealed class Student  permits Scholar  ,Graduate{

    private Integer id;
    private String name;
    private Integer age;
    private String course;

    public Student( Integer id , String name , Integer age , String course ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public Student(){}

    public Integer getId( ) {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Integer getAge( ) {
        return age;
    }

    public void setAge( Integer age ) {
        this.age = age;
    }

    public String getCourse( ) {
        return course;
    }

    public void setCourse( String course ) {
        this.course = course;
    }

    @Override
    public String toString() {
        return STR."""
            ---------------------------
            ID     : \{id}
            Name   : \{name}
            Age    : \{age}
            Course : \{course}
            """;
    }

    public void show() {
    }
}
