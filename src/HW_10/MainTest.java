package HW_10;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
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
        System.out.println("Task1.2 All books with price > 250");
        System.out.println(findProductsByTypeAndPrice(listOfProducts, BOOK, 250f));

        //Task2.2
        System.out.println("Task2.2 All books with discount");
        System.out.println(applyDiscount(listOfProducts));

        //Task3.3
        System.out.println("Task3.2 Find book with min price");
        System.out.println(findProductWithMinPrice(listOfProducts));

        // Task3.3
        System.out.println("Task3.3 Put exception if category not found");
        List<Product> listOfProducts2 = Arrays.asList(prod3, prod4);
        System.out.println(findProductsByType(listOfProducts2, BOOK));

        //Task4.2
        Product prodA = Product.builder()
                .type(BOOK)
                .price(200.25f)
                .addingDate(LocalDate.of(2016, Month.FEBRUARY, 11))
                .build();
        Product prodB = Product.builder()
                .type(BOOK)
                .addingDate(LocalDate.of(2024, Month.MARCH, 10))
                .price(301.10f)
                .build();
        Product prodC = Product.builder()
                .type(TOY)
                .price(13.15f)
                .addingDate(LocalDate.of(2024, Month.DECEMBER, 07))
                .build();
        Product prodD = Product.builder()
                .type(TOY)
                .price(85.15f)
                .addingDate(LocalDate.of(2024, Month.FEBRUARY, 02))
                .build();
        Product prodG = Product.builder()
                .type(BOOK)
                .price(5f)
                .addingDate(LocalDate.of(2023, Month.FEBRUARY, 04))
                .build();
        Product prodQ = Product.builder()
                .type(BOOK)
                .price(10f)
                .addingDate(LocalDate.of(2024, Month.FEBRUARY, 05))
                .build();
        Product prodZ = Product.builder()
                .type(BOOK)
                .price(20f)
                .addingDate(LocalDate.of(2024, Month.FEBRUARY, 06))
                .build();
        List<Product> listOfProducts3 = Arrays.asList(prodA, prodB, prodC, prodD, prodG, prodQ, prodZ);

        System.out.println("Task4.2 Last 3  added products");
        sortProductsByDate(listOfProducts3).stream().limit(3).forEach(System.out::println);

        // Task 5.2
        System.out.println("Task5.2 Sum of Book products of the last year with price< 75");
        System.out.println(getSumProductsLastYear(listOfProducts3));
    }

    public static List<Product> findProductsByTypeAndPrice(List<Product> products, String neededType, Float neededPrice) {
        return products.stream().filter(p -> p.getType().equals(neededType) && p.getPrice() > neededPrice).collect(Collectors.toList());
    }

    public static List<Product> applyDiscount(List<Product> listOfProducts) {
        List<Product> productsWithDiscount = findProductWithDiscount(listOfProducts);
        productsWithDiscount.forEach(p -> p.setPrice(p.getPrice() - p.getPrice() * 0.1f));
        return productsWithDiscount;
    }

    public static List<Product> findProductWithDiscount(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .filter(p -> p.getType().contains(BOOK))
                .collect(Collectors.toList());
    }

    private static List<Product> findProductsByType(List<Product> products, String type) {
        return products.stream().filter(p -> p.getType().equals(type))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> !l.isEmpty())
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Product category: %s not found", type)));
    }

    public static Product findProductWithMinPrice(List<Product> listOfProducts) {
        return findProductWithDiscount(listOfProducts).stream().min(Comparator.comparing(Product::getPrice)).get();
    }

    public static List<Product> sortProductsByDate(List<Product> listOfProducts) {
        return listOfProducts.stream().sorted(Comparator.comparing(Product::getAddingDate).reversed()).collect(Collectors.toList());
    }

    public static double getSumProductsLastYear(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .filter(p -> p.getType().equals(BOOK))
                .filter(p -> p.getAddingDate().isAfter(LocalDate.of(2023, Month.DECEMBER, 31)))
                .filter(p -> p.getPrice() < 75)
                .mapToDouble(p -> p.getPrice())
                .sum();
    }
}
