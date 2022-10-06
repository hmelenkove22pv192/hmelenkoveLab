package bank.service;

import bank.entity.*;

import java.util.Date;

public interface CreditAccountService {
    /**
     * создание экземпляра класса CreditAccount
     * @param bank экземпляр класса Bank
     * @param user экземпляр класса User
     * @param employee экземпляр класса Employee
     * @param paymentAccount экземпляр класса PaymentAccount
     * @param id идентификатор банкомата
     * @param startDate дата начала кредита
     * @param endDate дата окончания кредита
     * @param creditSum сумма кредита
     * @param monthPay ежемесячный платеж
     * */
    CreditAccount createCreditAcc(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                                         Integer id, Date startDate, Date endDate, Integer countMonth,
                                         Double creditSum, Double monthPay);
    /**
     * вывод в консоль экземпляра класса CreditAccount
     * @param creditAcc экземпляр класса CreditAccount
     * */
    void readCreditAcc(CreditAccount creditAcc);
    /**
     * обновление платежного счета
     * @param creditAcc экземпляр класса CreditAccount
     * @param payAcc новый платежный счет
     * */
    void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc);
}