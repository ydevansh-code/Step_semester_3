package week3.assigment_problems;

public class Product {
    String productId;
    String productName;

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public static void main(String[] args) {
        Product prod = new Product("P-1042", "Wireless Mouse");
        System.out.println(prod.productId + " - " + prod.productName);
    }
}
