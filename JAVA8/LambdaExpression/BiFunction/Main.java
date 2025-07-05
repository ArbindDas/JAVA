package JAVA8.LambdaExpression.BiFunction;

import java.util.function.BiFunction;

public class Main
{
    public static void main( String[] args ) {

        BiFunction<Integer  , Integer , Integer> add =Integer :: sum;
        System.out.println (add.apply ( 10, 10 ) );
    }
}
