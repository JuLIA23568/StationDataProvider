package by.bsuir.station.service.impl;

import by.bsuir.station.dao.AbstractDAO;
import by.bsuir.station.entity.Purchase;
import by.bsuir.station.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired private AbstractDAO<Purchase> dao;

    public Purchase save(Purchase purchase) throws Exception {
        if(purchase.getRoute().getPlacesLeft() > 0) {
            return dao.save(purchase);
        } else {
            throw new Exception("Can't create purchase. No places left");
        }
    }

    public Purchase update(Purchase purchase) {
        return dao.update(purchase);
    }

    public Purchase delete(Integer id) {
        return dao.delete(select(id));
    }

    public List<Purchase> select() {
        return dao.select(Purchase.class);
    }

    public Purchase select(Integer id) {
        return dao.select(Purchase.class, id);
    }

    @Override
    public List<Purchase> selectByUser(Integer userId) {
        return dao.customSelect("from Purchase p where p.user.userId =?", userId).list();
    }
}
