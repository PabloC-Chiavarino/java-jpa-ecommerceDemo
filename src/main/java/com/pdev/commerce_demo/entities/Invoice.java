package com.pdev.commerce_demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime createdAt;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn (name = "Client_id")
    private Client clientId;

    @OneToMany(mappedBy = "invoiceId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> invoiceDetails;

    public Invoice() {}
    public Invoice(LocalDateTime createdAt, Double totalPrice, Client clientId, List<InvoiceDetail> invoiceDetails) {
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
        this.clientId = clientId;
        this.invoiceDetails = invoiceDetails;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
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
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) && Objects.equals(createdAt, invoice.createdAt) && Objects.equals(totalPrice, invoice.totalPrice) && Objects.equals(clientId, invoice.clientId) && Objects.equals(invoiceDetails, invoice.invoiceDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, totalPrice, clientId, invoiceDetails);
    }

    //para el final
    /*@Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", totalPrice=" + totalPrice +
                ", clientId=" + clientId +
                ", invoiceDetails=" + invoiceDetails +
                '}';
    }*/
}
