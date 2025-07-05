package JAVA8.LambdaExpression.INTERVIEW.FunctionalInterface;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIPayment {

    String doPayment(String source  , String destination);


    default double getScratchcard( ) {
        return new Random (  ).nextDouble ();
    }

    static String datePatterns(String patterns){
        SimpleDateFormat dateFormat = new SimpleDateFormat ( patterns );
        return  dateFormat.format ( new Date (  ) );
    }
}
