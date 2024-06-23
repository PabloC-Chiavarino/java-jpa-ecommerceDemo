package com.pdev.commerce_demo.managers;

import com.pdev.commerce_demo.entities.Client;
import com.pdev.commerce_demo.entities.Invoice;
import com.pdev.commerce_demo.entities.Product;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;

public class InvoiceManager extends _GenericManager<Invoice> {

    public InvoiceManager() throws Exception {
        super(Invoice.class);
    }

    public void newBuy(Client client, Product product, Integer amount) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Invoice invoice = new Invoice( LocalDateTime.now(), product.getPrice() * amount, client, null);
            em.persist(invoice);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
