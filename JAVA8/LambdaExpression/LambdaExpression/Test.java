package JAVA8.LambdaExpression.LambdaExpression;

public class Test {
    static void main() {
        Child child = new Child("Arbind" , 199);

        child.setAge(100);

        int age = child.getAge();
        System.out.println(age);
    }
}
