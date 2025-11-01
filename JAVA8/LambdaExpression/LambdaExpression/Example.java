package JAVA8.LambdaExpression.LambdaExpression;

public abstract class Example {
    private int age;
    public Example() {
    }

    public Example(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Child extends Example{


    private String name;
    public Child(String name , int age) {
//        if (age<0){
//            throw new IllegalArgumentException("Invalid age : "+age);
//        }
        super(18);

        this.name = name;
    }
}

