package by.bsuir.station.service;

import by.bsuir.station.entity.Bus;

import java.util.List;

public interface BusService {
    Bus save(Bus bus);
    Bus update(Bus bus);
    Bus delete(Integer id);
    List<Bus> select();
    Bus select(Integer id);
}
