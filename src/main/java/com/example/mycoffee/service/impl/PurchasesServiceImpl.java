package com.example.mycoffee.service.impl;

import com.example.mycoffee.dao.PurchasesDAO;
import com.example.mycoffee.entities.Purchases;
import com.example.mycoffee.service.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasesServiceImpl implements PurchasesService {
    @Autowired
    private PurchasesDAO purchasesDAO;

    @Override
    public void addPurchases(Purchases purchases) {
        purchasesDAO.addPurchases(purchases);
    }

    @Override
    public Purchases getPurchases(Long id) {
        return purchasesDAO.getPurchases(id);
    }
}
