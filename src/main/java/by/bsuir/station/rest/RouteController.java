package by.bsuir.station.rest;

import by.bsuir.station.entity.Route;
import by.bsuir.station.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/route")
public class RouteController {

    @Autowired private RouteService routeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Route[] get(@RequestParam(value = "search", required = false) String searchQuery) {
        List<Route> list = routeService.select(searchQuery);
        return list.toArray(new Route[list.size()]);
    }

    @RequestMapping(value = "/{routeId}", method = RequestMethod.GET)
    @ResponseBody
    public Route get(@PathVariable Integer routeId) {
        return routeService.select(routeId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Route post(@RequestBody Route route) {
        return routeService.save(route);
    }

    @RequestMapping(value = "/{routeId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Route delete(@PathVariable Integer routeId) {
        return routeService.delete(routeId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public Route put(@RequestBody Route route) {
        return routeService.update(route);
    }
}
