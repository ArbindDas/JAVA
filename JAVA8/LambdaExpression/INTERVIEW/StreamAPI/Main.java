package JAVA8.LambdaExpression.INTERVIEW.StreamAPI;

import java.util.*;
import java.util.stream.Collectors;


class Products {


    private int id;
    private String productName;
    private double productPrice;


    public int getId( ) {
        return id;
    }

    public String getProductName( ) {
        return productName;
    }

    public double getProductPrice( ) {
        return productPrice;
    }

    public void setId( int id ) {
        this.id=id;
    }

    public void setProductName( String productName ) {
        this.productName=productName;
    }

    public void setProductPrice( double productPrice ) {
        this.productPrice=productPrice;
    }

    public Products( int id , String productName , double productPrice ) {
        this.id=id;
        this.productName=productName;
        this.productPrice=productPrice;
    }

    public Products( ) {
    }

    @Override
    public String toString( ) {
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}

public class Main {
    public static void main( String[] args ) {


        List < Products > productsList=new ArrayList <> ( List.of (
                new Products ( 1 , "jeans" , 8900 ),
                new Products ( 1 , "jeans" , 900 ) ,
                new Products ( 2 , "T-Shirt" , 500 ) ,
                new Products ( 3 , "Sneakers" , 1500 ) ,
                new Products ( 4 , "jacket" , 2000 ) ,
                new Products ( 5 , "Backpack" , 1200 ) ,
                new Products ( 6 , "Watch" , 2500 ) ,
                new Products ( 7 , "Sunglasses" , 800 ) ,
                new Products ( 8 , "Hat" , 400 ) ,
                new Products ( 9 , "Shoes" , 1800 )

        ) );
//   todo     1. Filter Products by Price > 1000
        System.out.println ("the products that price is gt 1000" );
        List<Products>expensiveProducts = productsList.stream ()
                .filter ( products -> products.getProductPrice () > 1000 )
                .toList ();

        expensiveProducts.forEach ( System.out::println );


        System.out.println ( );

//        2. Map Product Names to a List
        System.out.println ("all products names are show bellow" );
            List<String>ProductName = productsList.stream ()
                    .map ( Products :: getProductName )
                    .toList ();


            ProductName.forEach ( System.out::println );


        System.out.println ( );


//        3. Find the Most Expensive Product
        System.out.println ("the Most Expensive Product" );
        Optional <Products> ExpensiveProducts = productsList.stream ()
                .max ( Comparator.comparing ( Products :: getProductPrice ) );
        ExpensiveProducts.ifPresent (
                product -> {
                    System.out.println("Name: " + product.getProductName() + ", Price: " + product.getProductPrice());
                }
        );


        System.out.println ( );


//        4. Find the Cheapest Product
        System.out.println ("the Cheapest Product" );
        Optional<Products> minProduct = productsList.stream()
                .min(Comparator.comparing(Products::getProductPrice));

        minProduct.ifPresent (
                product -> {
                    System.out.println("Name: " + product.getProductName() + ", Price: " + product.getProductPrice());
                }
        );


        System.out.println ( );

//        5. Calculate Total Price of All Products
        double totalPrice = productsList.stream ()
                .mapToDouble ( Products::getProductPrice )
                .sum ();

        System.out.println ("the total price of our products is : "+totalPrice );






//        6. Count Products Cheaper than ₹1000
        long countProdouctCheapethean1000 = productsList.stream ()
                .filter ( products -> products.getProductPrice () <1000 )
                .count ();


        System.out.println (countProdouctCheapethean1000 );


        System.out.println ( );



//        7. Group Products by Name
        Map<String , List<Products>> groupedByName = productsList.stream ()
                .collect ( Collectors.groupingBy ( Products::getProductName ) );



        groupedByName.forEach((name, productList) -> {
            System.out.println("Product Name: " + name);
            productList.forEach(product ->
                    System.out.println("  ID: " + product.getId () + ", Price: " + product.getProductPrice())
            );
        });





//
//        List<Products>productsWithPriceMoreThan100 = productsList.stream ()
//                .filter ( products -> products.getProductPrice () > 1000
//                        && products.getProductName ().startsWith ( "j" ))
//                .toList ();


//        ✅ 1. Using forEach with Lambda:
//        productsWithPriceMoreThan100.forEach ( products -> {
//            System.out.println (
//                    products.getId () + " " + products.getProductName () + " " + products.getProductPrice ()
//            );
//        } );

      //  ✅ 2. Using Method Reference (if toString() is defined):
//      productsWithPriceMoreThan100.forEach (System.out::println );
    }
}
