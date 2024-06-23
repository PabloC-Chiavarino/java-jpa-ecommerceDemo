package com.pdev.commerce_demo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private String code;
    private Integer stock;
    private Double price;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> invoiceDetails;

    public Product() {}
    public Product(String description, String code, Integer stock, Double price) {
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(description, product.description) && Objects.equals(code, product.code) && Objects.equals(stock, product.stock) && Objects.equals(price, product.price) && Objects.equals(invoiceDetails, product.invoiceDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, code, stock, price, invoiceDetails);
    }

    //para el final
    /*@Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", invoiceDetails=" + invoiceDetails +
                '}';
    }*/
}
