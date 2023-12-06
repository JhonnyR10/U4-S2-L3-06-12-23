package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    public long id;
    public String status;
    public LocalDate orderDate;
    public LocalDate deliveryDate;
    public List<Product> products;
    public Customer customer;

    public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public static List<Product> filterBooksExpensive(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100)
                .collect(Collectors.toList());
    }

    public static List<Order> filterOrdersWithBabyProducts(List<Order> orderList) {
        return orderList.stream()
                .filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby")))
                .collect(Collectors.toList());
    }

    public static List<Product> applyDiscountToBoysProducts(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .map(product -> {
                    product.setPrice(product.getPrice() * 0.9);
                    return product;
                })
                .collect(Collectors.toList());
    }

//    public static List<Product> getProductsOrderedByTier2CustomersBetweenDates(List<Order> orderList, LocalDate startDate, LocalDate endDate) {
//        return orderList.stream()
//                .filter(order -> order.getCustomer().getTier() == 2 &&
//                        order.getOrderDate().isAfter(startDate.minusDays(1)) &&
//                        order.getOrderDate().isBefore(endDate.plusDays(1)))
//                .flatMap(order -> order.getProducts().stream())
//                .collect(Collectors.toList());
//    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
