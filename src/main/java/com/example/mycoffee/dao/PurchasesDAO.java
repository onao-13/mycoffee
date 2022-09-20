package com.example.mycoffee.dao;

import com.example.mycoffee.entities.Purchases;

public interface PurchasesDAO {
    void addPurchases(Purchases purchases);
    Purchases getPurchases(Long id);
}
