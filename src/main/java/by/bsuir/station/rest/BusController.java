package by.bsuir.station.rest;

import by.bsuir.station.entity.Bus;
import by.bsuir.station.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/bus")
public class BusController {

    @Autowired private BusService busService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Bus[] get() {
        List<Bus> list = busService.select();
        return list.toArray(new Bus[list.size()]);
    }

    @RequestMapping(value = "/{busId}", method = RequestMethod.GET)
    @ResponseBody
    public Bus get(@PathVariable Integer busId) {
        return busService.select(busId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Bus post(@RequestBody Bus bus) {
        return busService.save(bus);
    }

    @RequestMapping(value = "/{busId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Bus delete(@PathVariable Integer busId) {
        return busService.delete(busId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public Bus put(@RequestBody Bus bus) {
        return busService.update(bus);
    }

}
