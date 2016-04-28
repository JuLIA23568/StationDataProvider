package by.bsuir.station.rest;

import by.bsuir.station.entity.Destination;
import by.bsuir.station.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/destination")
public class DestinationController {

    @Autowired private DestinationService destinationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Destination[] get() {
        List<Destination> list = destinationService.select();
        return list.toArray(new Destination[list.size()]);
    }

    @RequestMapping(value = "/{destinationId}", method = RequestMethod.GET)
    @ResponseBody
    public Destination get(@PathVariable Integer destinationId) {
        return destinationService.select(destinationId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Destination post(@RequestBody Destination destination) {
        return destinationService.save(destination);
    }

    @RequestMapping(value = "/{destinationId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Destination delete(@PathVariable Integer destinationId) {
        return destinationService.delete(destinationId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public Destination put(@RequestBody Destination destination) {
        return destinationService.update(destination);
    }
}
