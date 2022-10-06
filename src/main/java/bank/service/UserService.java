package bank.service;

import bank.entity.User;

import java.util.Date;

public interface UserService {
    /**
     * создание экземпляра класса User
     * @param id идентификатор клиента
     * @param fullName полное имя клиента
     * @param birthDay дата рождения клиента
     * @param workPlace место работы клиента
     * */
    User createUser(Integer id, String fullName, Date birthDay, String workPlace);
    /**
     * вывод в консоль экземпляра класса User
     * @param user экземпляр класса User
     * */
    void readUser(User user);
    /**
     * обновление места работы клиент
     * @param user экземпляр класса User
     * @param workPlace новое место работы
     * */
    void updateUserWork(User user, String workPlace);
}