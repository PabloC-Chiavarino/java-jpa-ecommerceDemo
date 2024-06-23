package com.pdev.commerce_demo.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Clients")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String lastName;
    private Integer docNumber;

    @OneToMany(mappedBy = "clientId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;

    public Client() {}
    public Client(String name, String lastName, Integer docNumber) {
        this.name = name;
        this.lastName = lastName;
        this.docNumber = docNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Integer docNumber) {
        this.docNumber = docNumber;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(lastName, client.lastName) && Objects.equals(docNumber, client.docNumber) && Objects.equals(invoices, client.invoices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, docNumber, invoices);
    }

    //para el final
    /*@Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", docNumber=" + docNumber +
                ", invoices=" + invoices +
                '}';
    }*/
}
