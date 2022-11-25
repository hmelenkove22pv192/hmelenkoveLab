package bank.service;

import bank.entity.*;

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
                                         Integer id, String startDate, String endDate, Integer countMonth,
                                         Double creditSum, Double monthPay);
    /**
     * возвращает экземпляр класса CreditAccount
     * @param id экземпляра класса CreditAccount
     * */
    CreditAccount readCreditAcc(Integer id);
    /**
     * обновление платежного счета
     * @param creditAcc экземпляр класса CreditAccount
     * @param payAcc новый платежный счет
     * */
    void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc);
}