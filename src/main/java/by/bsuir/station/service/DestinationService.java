package by.bsuir.station.service;

import by.bsuir.station.entity.Destination;

import java.util.List;

public interface DestinationService {
    Destination save(Destination destination);
    Destination update(Destination destination);
    Destination delete(Integer id);
    List<Destination> select();
    Destination select(Integer id);
}
