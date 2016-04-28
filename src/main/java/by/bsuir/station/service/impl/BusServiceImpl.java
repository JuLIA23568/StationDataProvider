package by.bsuir.station.service.impl;

import by.bsuir.station.dao.AbstractDAO;
import by.bsuir.station.entity.Bus;
import by.bsuir.station.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BusServiceImpl implements BusService {
    @Autowired private AbstractDAO<Bus> dao;

    public Bus save(Bus bus) {
        return dao.save(bus);
    }

    public Bus update(Bus bus) {
        return dao.update(bus);
    }

    public Bus delete(Integer id) {
        return dao.delete(select(id));
    }

    public List<Bus> select() {
        return dao.select(Bus.class);
    }

    public Bus select(Integer id) {
        return dao.select(Bus.class, id);
    }
}
