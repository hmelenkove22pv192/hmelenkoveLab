package bank.service.impl;

import bank.entity.User;
import bank.service.UserService;
import bank.utils.FullName;

import java.util.Date;

public class UserImpl implements UserService {
    public UserImpl(){}
    @Override
    public User createUser(Integer id, FullName fullName, Date birthDay, String workPlace) {
        return new User(id, fullName, birthDay, workPlace);
    }

    @Override
    public void readUser(User user) {
        System.out.println("id: " + user.getIdUser());
        System.out.println("fullName: " + user.getFullName());
        System.out.println("birthDay: " + user.getBirthDay());
        System.out.println("workPlace: " + user.getWorkPlace());
        System.out.println("monthSalary: " + user.getMonthSalary());
        System.out.println("creditRating: " + user.getCreditRating());
    }

    @Override
    public void updateUserWork(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }

    @Override
    public void deleteUser(User user) {
        user = null;
    }
}
