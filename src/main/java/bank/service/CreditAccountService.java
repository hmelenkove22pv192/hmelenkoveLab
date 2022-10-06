package bank.service;

import bank.entity.*;

import java.util.Date;

public interface CreditAccountService {
    /**
     * создание экземпляра класса CreditAccount
     * bank - экземпляр класса Bank
     * user - экземпляр класса User
     * employee - экземпляр класса Employee
     * paymentAccount - экземпляр класса PaymentAccount
     * id - идентификатор банкомата
     * startDate - дата начала кредита
     * endDate - дата окончания кредита
     * creditSum - сумма кредита
     * monthPay - ежемесячный платеж
     * */
    CreditAccount createCreditAcc(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                                         Integer id, Date startDate, Date endDate, Integer countMonth,
                                         Double creditSum, Double monthPay);
    /**
     * вывод в консоль экземпляра класса CreditAccount
     * */
    void readCreditAcc(CreditAccount creditAcc);
    /**
     * обновление платежного счета
     * creditAcc - экземпляр класса CreditAccount
     * payAcc - новый платежный счет
     * */
    void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc);
}