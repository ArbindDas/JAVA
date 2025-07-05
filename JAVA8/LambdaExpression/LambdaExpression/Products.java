package JAVA8.LambdaExpression.LambdaExpression;


public class Products {

    private  int productId;

    private  String ProductName;

    private  int ProductPrice;


    public int getProductId( ) {
        return productId;
    }

    public String getProductName( ) {
        return ProductName;
    }

    public int getProductPrice( ) {
        return ProductPrice;
    }


    public void setProductId( int productId ) {
        this.productId=productId;
    }

    public void setProductName( String productName ) {
        ProductName=productName;
    }

    public void setProductPrice( int productPrice ) {
        ProductPrice=productPrice;
    }

    public Products( int productId , String productName , int productPrice ) {
        this.productId=productId;
        ProductName=productName;
        ProductPrice=productPrice;
    }


    public Products(){

    }

    @Override
    public String toString( ) {
        return "Products{" +
                "productId=" + productId +
                ", ProductName='" + ProductName + '\'' +
                ", ProductPrice=" + ProductPrice +
                '}';
    }
}
