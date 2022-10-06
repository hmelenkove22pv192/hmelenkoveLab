package bank.service;

import bank.entity.Bank;
import bank.entity.PaymentAccount;
import bank.entity.User;

public interface PaymentAccountService {
    /**
     * создание экземпляра класса PaymentAccount
     * bank - экземпляр класса Bank
     * user - экземпляр класса User
     * id - идентификатор платежного счета
     * */
    PaymentAccount createPayAcc(Bank bank, User user, Integer id);
    /**
     * вывод в консоль экземпляра класса PaymentAccount
     * */
    void readPayAcc(PaymentAccount paymentAccount);
    /**
     * обновление суммы денег на счету
     * paymentAccount - экземпляр класса PaymentAccount
     * money - новая сумма
     * */
    void updateMoney(PaymentAccount paymentAccount, Double money);
}