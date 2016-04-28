package by.bsuir.station.rest;

import by.bsuir.station.entity.Purchase;
import by.bsuir.station.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Autowired private PurchaseService purchaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Purchase[] get() {
        List<Purchase> list = purchaseService.select();
        return list.toArray(new Purchase[list.size()]);
    }

    @RequestMapping(value = "/{purchaseId}", method = RequestMethod.GET)
    @ResponseBody
    public Purchase get(@PathVariable Integer purchaseId) {
        return purchaseService.select(purchaseId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Purchase post(@RequestBody Purchase purchase) throws Exception {
        return purchaseService.save(purchase);
    }

    @RequestMapping(value = "/{purchaseId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Purchase delete(@PathVariable Integer purchaseId) {
        return purchaseService.delete(purchaseId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public Purchase put(@RequestBody Purchase purchase) {
        return purchaseService.update(purchase);
    }
}
