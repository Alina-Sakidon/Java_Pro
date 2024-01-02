package HW_10;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static HW_10.Product.Type.*;

public class MainTest {
    public static void main(String[] args) {
        Product prod1 = Product.builder()
                .type(BOOK)
                .price(200.25f)
                .build();
        Product prod2 = Product.builder()
                .type(BOOK)
                .price(305.10f)
                .build();
        Product prod3 = Product.builder()
                .type(TOY)
                .price(13.15f)
                .build();
        Product prod4 = Product.builder()
                .type(TOY)
                .price(85.15f)
                .build();
        List<Product> listOfProducts = Arrays.asList(prod1, prod2, prod3, prod4);

        //Task1.2
        System.out.println(findProductsByTypeAndPrice(listOfProducts, BOOK, 250f));

        //Task2.2
        System.out.println(applyDiscount(listOfProducts));

        //Task3.3
        System.out.println(findProductWithMinPrice(listOfProducts));

      /*  // Task3.3
        List<Product> listOfProducts2 = Arrays.asList(prod3, prod4);
        System.out.println(findProductsByType(listOfProducts2, BOOK));*/

        //Task4.2
        Product prodA = Product.builder()
                .type(BOOK)
                .price(200.25f)
                .addingDate(LocalDate.of(2016, Month.FEBRUARY, 11))
                .build();
        Product prodB = Product.builder()
                .type(BOOK)
                .addingDate(LocalDate.of(2024, Month.MARCH, 18))
                .price(305.10f)
                .build();
        Product prodC = Product.builder()
                .type(TOY)
                .price(13.15f)
                .addingDate(LocalDate.of(2024, Month.DECEMBER, 21))
                .build();
        Product prodD = Product.builder()
                .type(TOY)
                .price(85.15f)
                .addingDate(LocalDate.of(2024, Month.FEBRUARY, 16))
                .build();
        List<Product> listOfProducts2 = Arrays.asList(prodA, prodB, prodC, prodD);
       List<Product> sortedByDate = applyDiscount(listOfProducts2).stream().sorted(Comparator.comparing(Product::getAddingDate)).collect(Collectors.toList());


    }

    public static List<Product> findProductsByTypeAndPrice(List<Product> products, String neededType, Float neededPrice) {
        return products.stream().filter(p -> p.getType().equals(neededType)).filter(p -> p.getPrice() > neededPrice).collect(Collectors.toList());
    }

    public static List<Product> applyDiscount(List<Product> listOfProducts) {
        listOfProducts.stream().filter()
        List<Product> productsWithDiscount = findProductWithDiscount(listOfProducts);
        productsWithDiscount.forEach(p -> p.setDiscount(true));
        productsWithDiscount.forEach(p -> p.setPrice(p.getPrice() - p.getPrice() * 0.1f));
        return productsWithDiscount;
    }

    public static List<Product> findProductWithDiscount(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .filter(p -> p.getType().contains(BOOK))
                .collect(Collectors.toList());
    }

    private  List<Product> findProductsByType(List<Product> products, String type) {
        return products.stream().filter(p -> p.getType().contains(type))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty())
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Product category: %s not found", type)));
    }

    public static Product findProductWithMinPrice(List<Product> listOfProducts) {
        return findProductWithDiscount(listOfProducts).stream().min(Comparator.comparing(Product::getPrice)).get();
    }


}
