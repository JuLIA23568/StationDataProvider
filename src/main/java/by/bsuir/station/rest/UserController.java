package by.bsuir.station.rest;

import by.bsuir.station.entity.Purchase;
import by.bsuir.station.entity.User;
import by.bsuir.station.service.PurchaseService;
import by.bsuir.station.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired private UserService userService;
    @Autowired private PurchaseService purchaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public User[] get() {
        List<User> list = userService.select();
        return list.toArray(new User[list.size()]);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User get(@PathVariable Integer userId) {
        return userService.select(userId);
    }

    @RequestMapping(value = "/{userId}/purchases", method = RequestMethod.GET)
    @ResponseBody
    public List<Purchase> getPurchases(@PathVariable Integer userId) {
        return purchaseService.selectByUser(userId);
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    @ResponseBody
    public User get(@PathVariable String login) { return userService.select(login); }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public User post(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public User put(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public User delete(@PathVariable Integer userId) {
        return userService.delete(userId);
    }
}
