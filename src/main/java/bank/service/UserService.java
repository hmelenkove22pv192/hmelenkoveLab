package bank.service;

import bank.entity.User;
import bank.utils.UserInputException;

import java.util.Date;

public interface UserService {
    /**
     * сохраняет ссылку на объект платежных счетов
     * @param payService экземпляра класса PaymentAccountService
     * */
    void setPayService(PaymentAccountService payService) ;

    /**
     * сохраняет ссылку на объект кредитов
     * @param creditService экземпляра класса CreditAccountService
     * */
    public void setCreditService(CreditAccountService creditService) ;

    /**
     * создание экземпляра класса User
     * @param id идентификатор клиента
     * @param fullName полное имя клиента
     * @param birthDay дата рождения клиента
     * @param workPlace место работы клиента
     * */
    User createUser(Integer id, String fullName, Date birthDay, String workPlace);

    /**
     * возвращает экземпляр класса User
     * @param id экземпляра класса User
     * */
    User readUser(Integer id) ;

    /**
     * обновление места работы клиент
     * @param user экземпляр класса User
     * @param workPlace новое место работы
     * */
    void updateUserWork(User user, String workPlace);

    /**
     * возвращает массив id банка, офиса, сотрудника и atm,
     * которые могут выдать кредит клиенту
     * @param moneyForCredit сумма кредита
     * */
    int[] searchPlaceForUserCredit(Double moneyForCredit) throws UserInputException;

    /**
     * функция создание кредита для клиента
     * @param id экземпляра класса User
     * @param moneyForCredit деньги, которые клиент хочет взять в кредит
     * */
    void giveUserCredit(Integer id, Double moneyForCredit) throws UserInputException;
}