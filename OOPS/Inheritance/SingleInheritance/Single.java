package OOPS.Inheritance.SingleInheritance;

public class Single {

    private Integer id;
    private String name;
    private String address;

    // All-args constructor
    public Single(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Single(){}

    // Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    public void printStudentDetails(){
        System.out.println("id: "+id);
        System.out.println("name: "+name);
        System.out.println("address: "+address);

    }


}
