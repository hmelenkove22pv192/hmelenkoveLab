package bank.service;

import bank.entity.User;

public interface UserService {
    void changeWork(User user, String newWork, Double newMonthSalary);
}