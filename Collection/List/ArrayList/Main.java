package Collection.List.ArrayList;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        



        ArrayList<Integer>integers = new ArrayList<>();


        integers.add(100);
        integers.add(90);
        integers.add(80);
        integers.add(70);
        integers.add(60);
        integers.add(50);

        for(Integer integer : integers){
            System.out.println(integer);
        }



       integers.forEach(integer -> System.out.println(integer));


    


       // Using method reference
        integers.forEach(System.out::println);


    }
    
}
