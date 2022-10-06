package bank.service;

import bank.entity.User;

import java.util.Date;

public interface UserService {
    User createUser(Integer id, String fullName, Date birthDay, String workPlace);
    void readUser(User user);
    void updateUserWork(User user, String workPlace);
}