package Test;

public class Main {
    static void main() {

        ShowingProductDetails showingProductDetails = new ShowingProductDetails();

        showingProductDetails.setId(1);
        showingProductDetails.setProductName("DRJ");
        showingProductDetails.setProductPrice(8900.0);

        System.out.println(showingProductDetails.toString());

        System.out.println("Is productDetails a Product? " + (showingProductDetails instanceof Product));
        System.out.println("Is productDetails a ProductService? " + (showingProductDetails instanceof ProductService));
        System.out.println("Is productDetails a ShowingProductDetails? "
                + (showingProductDetails instanceof ShowingProductDetails));

    }
}
