package JAVA8.LambdaExpression.LambdaExpression;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // ✅ Create a list of Products with sample data
        List<Products> products = List.of(
                new Products(1, "jeans", 5000),
                new Products(2, "shirt", 9000),
                new Products(3, "half pant", 400),
                new Products(4, "underwear", 200),
                new Products(5, "half pant", 560)
        );

        // 1️⃣ Print all products using a traditional for-each loop
        for (Products product : products) {
            System.out.println(product);
        }

        // 2️⃣ Print all products using Stream's forEach method (method reference)
        products.forEach(System.out::println);

        // 3️⃣ Extract only product names into a separate list
        List<String> list = products.stream()
                .map(Products::getProductName)
                .toList();

        System.out.println(list);

        // 4️⃣ Get products whose price is greater than 500
        //     Sort them by price (ascending) and limit to the first 2 results
        List<Products> filteredSortedList = products.stream()
                .filter(p -> p.getProductPrice() > 500)
                .sorted(Comparator.comparing(Products::getProductPrice))
                .limit(2)
                .toList();

        // System.out.println(filteredSortedList);

        // 5️⃣ Find the most expensive product (maximum price)
        Products mostExpensiveProduct = products.stream()
                .max(Comparator.comparing(Products::getProductPrice))
                .orElseThrow(() -> new RuntimeException("No products available"));

        System.out.println(mostExpensiveProduct);

        // 6️⃣ Find the cheapest product (minimum price)
        Products cheapestProduct = products.stream()
                .min(Comparator.comparing(Products::getProductPrice))
                .orElseThrow(() -> new RuntimeException("Product not found"));

        System.out.println(cheapestProduct);

        // 7️⃣ Calculate the total sum of all product prices using mapToInt().sum()
        int sum = products.stream()
                .mapToInt(Products::getProductPrice)
                .sum();
        System.out.println(sum);

        // 8️⃣ Calculate the total sum of all product prices using reduce()
        Integer reduce = products.stream()
                .map(Products::getProductPrice)
                .reduce(0, Integer::sum);
        System.out.println(reduce);

        // 9️⃣ Group products by their product name
        Map<String, List<Products>> collect = products.stream()
                .collect(Collectors.groupingBy(Products::getProductName));

        collect.forEach((name, list1) -> {
            System.out.println("Product name: " + name);
            list1.forEach(System.out::println);
        });

        // 🔟 Group products by product name and count how many items exist per group
        Map<String, Long> countProduct = products.stream()
                .collect(Collectors.groupingBy(Products::getProductName, Collectors.counting()));

        countProduct.forEach((name, c) -> {
            System.out.println("Product name -> " + name + " | Count -> " + c);
        });

        // 1️⃣1️⃣ Group products by product name and calculate average price per group
        Map<String, Double> avgPriceByName = products.stream()
                .collect(Collectors.groupingBy(
                        Products::getProductName,
                        Collectors.averagingInt(Products::getProductPrice)
                ));

        avgPriceByName.forEach((name, avg) -> {
            System.out.println("Product name -> " + name + " | Average price -> " + avg);
        });
    }



}
