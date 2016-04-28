package by.bsuir.station.service.impl;

import by.bsuir.station.dao.AbstractDAO;
import by.bsuir.station.entity.User;
import by.bsuir.station.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired private AbstractDAO<User> dao;

    private ShaPasswordEncoder encoder = new ShaPasswordEncoder();

    public User save(User user) {
        user.setPassword(encoder.encodePassword(user.getPassword(), null));
        return dao.save(user);
    }

    public User update(User user) {
        return dao.update(user);
    }

    public User delete(Integer id) {
        return dao.delete(select(id));
    }

    public List<User> select() {
        return dao.select(User.class);
    }

    public User select(Integer id) {
        return dao.select(User.class, id);
    }

    @Override
    public User select(String login) {
        return (User) dao.customSelect("from User u where u.login=?", login).uniqueResult();
    }
}
