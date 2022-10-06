package bank.service.impl;

import bank.entity.User;
import bank.service.UserService;

import java.util.Date;

public class UserImpl implements UserService {
    public UserImpl(){}
    @Override
    public User createUser(Integer id, String fullName, Date birthDay, String workPlace) {
        return new User(id, fullName, birthDay, workPlace);
    }

    @Override
    public void readUser(User user) {
        System.out.println(user.toString());
    }

    @Override
    public void updateUserWork(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }

}
