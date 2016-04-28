package by.bsuir.station.service.impl;

import by.bsuir.station.dao.AbstractDAO;
import by.bsuir.station.entity.Destination;
import by.bsuir.station.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DestinationServiceImpl implements DestinationService {
    @Autowired private AbstractDAO<Destination> dao;


    public Destination save(Destination destination) {
        return dao.save(destination);
    }

    public Destination update(Destination destination) {
        return dao.update(destination);
    }

    public Destination delete(Integer id) {
        return dao.delete(select(id));
    }

    public List<Destination> select() {
        return dao.select(Destination.class);
    }

    public Destination select(Integer id) {
        return dao.select(Destination.class, id);
    }
}
