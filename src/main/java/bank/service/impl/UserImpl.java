package bank.service.impl;

import bank.entity.User;
import bank.service.UserService;

import java.util.Date;

public class UserImpl implements UserService {
    public UserImpl(){}
    /**
     * создание экземпляра класса User
     * @param id идентификатор клиента
     * @param fullName полное имя клиента
     * @param birthDay дата рождения клиента
     * @param workPlace место работы клиента
     * */
    @Override
    public User createUser(Integer id, String fullName, Date birthDay, String workPlace) {
        return new User(id, fullName, birthDay, workPlace);
    }

    /**
     * вывод в консоль экземпляра класса User
     * @param user экземпляр класса User
     * */
    @Override
    public void readUser(User user) {
        System.out.println(user);
    }

    /**
     * обновление места работы клиент
     * @param user экземпляр класса User
     * @param workPlace новое место работы
     * */
    @Override
    public void updateUserWork(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }

}
