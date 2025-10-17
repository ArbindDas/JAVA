package Test;

public final class ShowingProductDetails extends ProductService {


    public static void describe(Product product){

        switch (product){
            case ShowingProductDetails sh -> System.out.println("This is a product detail viewer.");
            case ProductService ps -> System.out.println("This is a service product.");
            default -> System.out.println("Unknown product type.");
        }
    }

}
