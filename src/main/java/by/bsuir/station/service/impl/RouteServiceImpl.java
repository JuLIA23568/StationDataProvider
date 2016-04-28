package by.bsuir.station.service.impl;

import by.bsuir.station.dao.AbstractDAO;
import by.bsuir.station.entity.Route;
import by.bsuir.station.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {
    @Autowired private AbstractDAO<Route> dao;

    public Route save(Route route) {
        return dao.save(route);
    }

    public Route update(Route route) {
        return dao.update(route);
    }

    public Route delete(Integer id) {
        return dao.delete(select(id));
    }

    public List<Route> select(String searchQuery) {
        if(searchQuery == null || searchQuery.length() == 0) {
            return dao.select(Route.class);
        } else {
            searchQuery = "%" + searchQuery + "%";
            return dao.customSelect("from Route r where r.destination.departure like ? or r.destination.arrive like ?", searchQuery, searchQuery).list();
        }
    }

    public Route select(Integer id) {
        return dao.select(Route.class, id);
    }
}
