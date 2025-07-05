package JAVA8.LambdaExpression.INTERVIEW.FunctionalInterface;

public class Main {

    public static void main( String[] args ) {



        // this is concreate class based example
     // todo Use a concrete class when the logic is complex, stateful, or reused in multiple places.
        UPIPayment payment = new Paytm ();

        String result = payment.doPayment ( "delhi", "kathmandu" );
        System.out.println ("payment result "+result );

        double scratchAmount = payment.getScratchcard ();
        System.out.println("Scratchcard amount: " + scratchAmount);


        //todo  Use lambda when the implementation is simple, stateless, and you just want quick behavior without boilerplate.
//      UPIPayment payment = ( source , destination ) -> {
//          String txDate = UPIPayment.datePatterns("yyyy-MM-dd");
//          return "source -> " + source + " destination -> " + destination + " date -> " + txDate;
//      };
//
//        String result = payment.doPayment("delhi", "kathmandu");
//        System.out.println("payment result " + result);
//
//
//        double scratchAmount = payment.getScratchcard();
//        System.out.println("Scratchcard amount: " + scratchAmount);
    }
}
