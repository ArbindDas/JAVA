package JAVA8.LambdaExpression.INTERVIEW.FunctionalInterface;

public class AmazonPay implements  UPIPayment{


    @Override
    public String doPayment( String source , String destination ) {
        return null;
    }

    @Override
    public double getScratchcard( ) {
        return UPIPayment.super.getScratchcard ( );
    }
}
