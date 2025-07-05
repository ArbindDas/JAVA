package JAVA8.LambdaExpression.LambdaExpressionWithFunctionalInterface;

public class Main {

    public static void greet(Gretting g) {
        g.say ();
    }

    public static void main( String[] args ) {


        PrintUsersName printUsersName = ( String username) -> System.out.println ("the username is : "+username );
        printUsersName.print ( "Arbind Das" );


        greet(() -> System.out.println ("jai shree ram" ));

        System.out.println ( );

        printUsersEmail printUsersEmail = ( String email) -> System.out.println ("the user email is : "+email );
        printUsersEmail.printEmail ( "dasarbind269@gmail.com" );

        Addtion addtion =(a , b) -> a+b;
        int ans = addtion.add ( 10 , 10 );
        System.out.println (ans );


        AdditionOfTwoNum additionOfTwoNum =Integer::sum;
        System.out.println (additionOfTwoNum.addition ( 30 ,10 ) );

    }
}
