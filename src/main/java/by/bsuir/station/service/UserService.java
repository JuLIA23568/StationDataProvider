package by.bsuir.station.service;

import by.bsuir.station.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User update(User user);
    User delete(Integer id);
    List<User> select();
    User select(Integer id);
    User select(String login);
}
