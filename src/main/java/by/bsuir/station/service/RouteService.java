package by.bsuir.station.service;

import by.bsuir.station.entity.Route;

import java.util.List;

public interface RouteService {
    Route save(Route route);
    Route update(Route route);
    Route delete(Integer id);
    List<Route> select(String searchQuery);
    Route select(Integer id);
}
