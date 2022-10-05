package bank.service;

import bank.entity.User;
import bank.utils.FullName;

import java.util.Date;

public interface UserService {
    User createUser(Integer id, FullName fullName, Date birthDay, String workPlace);
    void readUser(User user);
    void updateUserWork(User user, String workPlace);
    void deleteUser(User user);
}