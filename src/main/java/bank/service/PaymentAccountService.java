package bank.service;

import bank.entity.Bank;
import bank.entity.PaymentAccount;
import bank.entity.User;

public interface PaymentAccountService {
    /**
     * создание экземпляра класса PaymentAccount
     * @param bank экземпляр класса Bank
     * @param user экземпляр класса User
     * @param id идентификатор платежного счета
     * */
    PaymentAccount createPayAcc(Bank bank, User user, Integer id);
    /**
     * вывод в консоль экземпляра класса PaymentAccount
     * @param payAcc экземпляр класса PaymentAccount
     * */
    void readPayAcc(PaymentAccount payAcc);
    /**
     * обновление суммы денег на счету
     * @param payAcc экземпляр класса PaymentAccount
     * @param money новая сумма
     * */
    void updateMoney(PaymentAccount payAcc, Double money);
}