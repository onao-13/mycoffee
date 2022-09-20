package com.example.mycoffee.service;

import com.example.mycoffee.entities.Purchases;

public interface PurchasesService {
    void addPurchases(Purchases purchases);
    Purchases getPurchases(Long id);
}
