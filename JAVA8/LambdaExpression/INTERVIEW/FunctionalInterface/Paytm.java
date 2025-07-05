package JAVA8.LambdaExpression.INTERVIEW.FunctionalInterface;

public class Paytm implements  UPIPayment{

    @Override
    public  String doPayment(String source , String destination){
        String txDate=UPIPayment.datePatterns ( "yyyy-MM-dd" );
        return "source ->  "+ source + " " + "destination ->  " + destination + " " +  "date -> " + txDate;
    }

    @Override
    public double getScratchcard( ) {
        return UPIPayment.super.getScratchcard ( );
    }
}
