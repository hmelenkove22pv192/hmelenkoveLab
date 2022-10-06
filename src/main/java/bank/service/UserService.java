package bank.service;

import bank.entity.User;

import java.util.Date;

public interface UserService {
    /**
     * создание экземпляра класса User
     * id - идентификатор клиента
     * fullName - полное имя клиента
     * birthDay - дата рождения клиента
     * workPlace - место работы клиента
     * */
    User createUser(Integer id, String fullName, Date birthDay, String workPlace);
    /**
     * вывод в консоль экземпляра класса User
     * */
    void readUser(User user);
    /**
     * обновление места работы клиент
     * user - экземпляр класса User
     * workPlace - новое место работы
     * */
    void updateUserWork(User user, String workPlace);
}