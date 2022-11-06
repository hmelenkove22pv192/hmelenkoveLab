package bank.service.impl;

import bank.entity.PaymentAccount;
import bank.entity.User;
import bank.service.UserService;

import java.util.Date;
import java.util.Map;

public class UserImpl implements UserService {
    private Map<Integer, User> users;
    public UserImpl(){}

    @Override
    public User createUser(Integer id, String fullName, Date birthDay, String workPlace) {
        return users.put(id, new User(id, fullName, birthDay, workPlace));
    }

    @Override
    public User readUser(Integer id) {
        return users.get(id);
    }

    @Override
    public void updateUserWork(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }

}
