package bank.service.CRUD;

import bank.entity.User;
import bank.service.UserService;

public interface UserServiceOperations extends UserService {
    @Override
    public default void changeWork(User user, String newWork, Double newMonthSalary) {
        user.setWorkPlace(newWork);
        user.setMonthSalary(newMonthSalary);
        int creditRating = 0;
        int min = 0;
        int max = 1000;
        while ((min != 10000) && (creditRating == 0)) {
            if ((newMonthSalary <= max) && (newMonthSalary >= min))
                creditRating = max / 10;
            else {
                min += 1000;
                max += 1000;
            }
        }
        user.setCreditRating(creditRating);
    }
}
