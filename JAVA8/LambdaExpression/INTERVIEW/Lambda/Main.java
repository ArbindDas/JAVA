package JAVA8.LambdaExpression.INTERVIEW.Lambda;

public class Main
{

    public static void main( String[] args ) {

        Runnable runnable = ()-> System.out.println ("jai shree ram" );
        new Thread ( runnable ).start ();


//        Runnable runnable1 = new Runnable ( ) {
//            @Override
//            public void run( ) {
//                System.out.println ("jai shree ram" );
//            }
//        };
//
//        runnable1.run ();
    }
}

