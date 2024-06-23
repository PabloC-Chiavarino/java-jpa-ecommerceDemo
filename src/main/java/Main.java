import com.pdev.commerce_demo.entities.*;
import com.pdev.commerce_demo.managers.*;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws Exception {

        ClientManager client = new ClientManager();
        ProductManager product = new ProductManager();
        InvoiceManager invoice = new InvoiceManager();

        System.out.println("Bienvenido al ecommerce-demo de PDEV");

        product.save(new Product("T-Shirt", "ts4", 10, 24.5));
        product.save(new Product("T-Shirt-Black", "ts5", 5, 34.5));
        product.save(new Product("T-Shirt-White", "ts6", 5, 25.5));
        product.save(new Product("T-Shirt-Red", "ts7", 20, 26.5));
        product.save(new Product("T-Shirt-Blue", "ts8", 15, 24.5));
        product.save(new Product("T-Shirt-Green", "ts9", 15, 27.5));
        product.save(new Product("T-Shirt-Yellow", "ts10", 20, 28.5));
        product.save(new Product("T-Shirt-Purple", "ts11", 10, 23.5));
        product.save(new Product("T-Shirt-Orange", "ts12", 8, 22.5));
        product.save(new Product("T-Shirt-Pink", "ts13", 10, 29.5));
        product.save(new Product("T-Shirt-Brown", "ts14", 5, 29.5));

        client.save(new Client("John", "Wick", 123450));
        client.save(new Client("Michael", "Jackson", 546721));
        client.save(new Client("Bruce", "Wayne", 734521));
        client.save(new Client("Tony", "Stark", 187654));
        client.save(new Client("Steve", "Rogers", 436541));


        invoice.newBuy(client.findById(1), product.findById(1), 2);
        invoice.newBuy(client.findById(1), product.findById(2), 3);
        invoice.newBuy(client.findById(3), product.findById(1), 1);
        invoice.newBuy(client.findById(5), product.findById(3), 2);
        invoice.newBuy(client.findById(4), product.findById(5), 2);
        invoice.newBuy(client.findById(2), product.findById(4), 1);

       
        _GenericManager.closeEntityManagerFactory();
    }
}
