package by.bsuir.station.service;

import by.bsuir.station.entity.Purchase;
import by.bsuir.station.entity.User;

import java.util.List;

public interface PurchaseService {
    Purchase save(Purchase purchase) throws Exception;
    Purchase update(Purchase purchase);
    Purchase delete(Integer id);
    List<Purchase> select();
    Purchase select(Integer id);
    List<Purchase> selectByUser(Integer userId);
}
