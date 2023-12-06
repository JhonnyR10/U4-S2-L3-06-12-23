import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(1, "Book1", "Books", 20.0);
        Product product2 = new Product(2, "Toy1", "Toys", 50.0);
        Product product3 = new Product(3, "Book2", "Books", 145.0);
        Product product4 = new Product(4, "BabyToy", "Baby", 130.0);
        Product product5 = new Product(5, "BoyToy", "Boys", 180.0);

        Customer customer1 = new Customer(1, "Giovanni Longo", 1);
        Customer customer2 = new Customer(2, "Alessandra Longo", 2);

        Order order1 = new Order(101, "Shipped", LocalDate.of(2022, 1, 15), LocalDate.of(2022, 1, 20),
                List.of(product1, product2), customer1);

        Order order2 = new Order(102, "Delivered", LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 5),
                List.of(product3, product4), customer2);

        Order order3 = new Order(103, "Processing", LocalDate.of(2022, 3, 10), LocalDate.of(2022, 3, 15),
                List.of(product5), customer2);


        List<Product> productList = List.of(product1, product2, product3, product4, product5);
        List<Order> orderList = List.of(order1, order2, order3);

        // Esercizio #1: Ottenere una lista di prodotti che appartengono alla categoria «Books» ed hanno un prezzo > 100
        List<Product> expensiveBooks = Order.filterBooksExpensive(productList);
        System.out.println("Expensive Books: " + expensiveBooks);

        // Esercizio #2: Ottenere una lista di ordini con prodotti che appartengono alla categoria «Baby»
        List<Order> babyOrders = Order.filterOrdersWithBabyProducts(orderList);
        System.out.println("Orders with Baby Products: " + babyOrders);

        // Esercizio #3: Ottenere una lista di prodotti che appartengono alla categoria «Boys» ed applicare 10% di sconto al loro prezzo
        List<Product> discountedBoysProducts = Order.applyDiscountToBoysProducts(productList);
        System.out.println("Discounted Boys Products: " + discountedBoysProducts);

//        // Esercizio #4: Ottenere una lista di prodotti ordinati da clienti di livello (tier) 2 tra l’01-Feb-2021 e l’01-Apr-2021
//        LocalDate startDate = LocalDate.of(2021, 2, 1);
//        LocalDate endDate = LocalDate.of(2021, 4, 1);
//        List<Product> tier2ProductsBetweenDates = Order.getProductsOrderedByTier2CustomersBetweenDates(orderList, startDate, endDate);
//        System.out.println("Products ordered by Tier 2 customers between " + startDate + " and " + endDate + ": " + tier2ProductsBetweenDates);
    }
}
