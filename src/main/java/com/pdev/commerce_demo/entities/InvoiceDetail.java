package com.pdev.commerce_demo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Invoice_details")

public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String product;
    private Integer amount;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "Invoice_id")
    private Invoice invoiceId;

    @ManyToOne
    @JoinColumn(name = "Product_id")
    private Product productId;

    public InvoiceDetail() {}
    public InvoiceDetail(String product, Integer amount, Double price, Invoice invoiceId, Product productId) {
        this.product = product;
        this.amount = amount;
        this.price = price;
        this.invoiceId = invoiceId;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDetail that = (InvoiceDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(amount, that.amount) && Objects.equals(price, that.price) && Objects.equals(invoiceId, that.invoiceId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, amount, price, invoiceId, productId);
    }

    //para el final
    /*@Override
    public String toString() {
        return "InvoiceDetails{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", invoiceId=" + invoiceId +
                ", productId=" + productId +
                '}';
    }*/
}