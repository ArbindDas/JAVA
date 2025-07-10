package CollectionFramework.List.Projects.ScholarSync;

import java.util.*;

public class Main{
    private static final Scanner scanner=new Scanner(System.in);
    private static final List < Student > students=new ArrayList <>();
    private static final Map < String, Student > success=new HashMap <>();

    public static int getIntegerInput(String prompt){
        System.out.println(prompt);
        try {

            return Integer.parseInt(scanner.nextLine());
        } catch( NumberFormatException e ){
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static String getStringInput(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static void EmptyCheckerForStudent(List < Student > studentList){
        if (studentList.isEmpty()){
            System.out.println("student list is empty");
            return;
        }
    }

    public static void main(String[] args){

        while(true){
            Display();
            int choice=getIntegerInput("Enter the choice to be performed");
            switch(choice){

                case 1 -> AddStudent();
                case 2 -> ViewStudent();
                case 3 -> SortStudent();
                case 4 -> UpdateStudent();
                case 5 -> RemoveStudent();
                case 6 -> TotalStudent();
                case 7 -> {
                    try {
                        Thread.sleep(1000);
                    } catch( InterruptedException e ){
                        throw new RuntimeException(e);
                    }
                    System.out.println("Exiting.....");
                }
            }
        }
    }

    private static void TotalStudent(){
        long total=students.size();
        System.out.println(STR."The total student is : \{total}");
    }

    private static void RemoveStudent(){

        EmptyCheckerForStudent(students);
        Integer id=getIntegerInput("Enter the id to be removed");

        boolean removed=false;
        for(int i=0; i<students.size(); i++){

            if (students.get(i).getId()==id){
                students.remove(i);
                removed=true;

                break;
            } else{
                System.out.println(STR."Student is not found with id : \{id}");
            }
            if (removed){
                success.put("the student successfully removed " , students.get(i));
            } else{
                System.out.println(STR."Student is not found with id : \{id}");
            }
        }
    }

    private static void UpdateStudent(){
        EmptyCheckerForStudent(students);

        Integer id=getIntegerInput("Enter the id to be updated");

        Student foundedStudent=null;

        for(int i=0; i<students.size(); i++){
            if (students.get(i).getId()==id){
                foundedStudent=students.get(i);
            }
        }
        if (foundedStudent!=null){
            System.out.println(STR."We are going to update student : \{foundedStudent.getId()}");
            Integer age=getIntegerInput("Enter the newAge ["+foundedStudent.getAge()+"]:");
            String name=getStringInput("Enter the new Name["+foundedStudent.getName()+"]");
            String course=getStringInput("Enter the new Course ["+foundedStudent.getCourse()+"]");

            foundedStudent.setAge(age);
            foundedStudent.setName(name);
            foundedStudent.setCourse(course);

            success.put("the student is successfully updated" , foundedStudent);

        } else{
            System.out.println(STR."there is no student with id : \{id}");
        }

    }

    private static void SortStudent(){
        EmptyCheckerForStudent(students);
        System.out.println("The sorted student are ");
        List < Student > sortStudent=students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        sortStudent.forEach(System.out::println);
    }

    private static void ViewStudent(){

        EmptyCheckerForStudent(students);

        System.out.println("The students present in your School are");
        for(Student student : students){
            System.out.println(student);
        }
    }

    private static void AddStudent(){

        System.out.println("Add the Students ");

        Integer id=getIntegerInput("Enter the student id");
        String name=getStringInput("Enter the student name");
        Integer age=getIntegerInput("Enter the student age");
        String course=getStringInput("Enter the course name");

        Student student=new Student(id , name , age , course);
        students.add(student);
        success.put("student added successfully " , student);
    }

    public static void Display(){
        System.out.println("--------- Welcome to my ScholarSync ---------");
        System.out.println("1.AddStudent");
        System.out.println("2.ViewStudent");
        System.out.println("3.SortStudent");
        System.out.println("4.UpdateStudent");
        System.out.println("5.RemoveStudent");
        System.out.println("6.TotalStudent");
        System.out.println("7.Exit");
    }
}
