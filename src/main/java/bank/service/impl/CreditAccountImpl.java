package bank.service.impl;

import bank.entity.*;
import bank.service.CreditAccountService;

import java.util.Date;

public class CreditAccountImpl implements CreditAccountService {
    public CreditAccountImpl(){}
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
    @Override
    public CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                         PaymentAccount paymentAccount, Integer id, Date startDate,
                                         Date endDate, Integer countMonth, Double creditSum, Double monthPay) {
        return new CreditAccount(bank, user, employee, paymentAccount, id, startDate,
                endDate, countMonth, creditSum, monthPay);
    }

    /**
     * вывод в консоль экземпляра класса CreditAccount
     * @param creditAcc экземпляр класса CreditAccount
     * */
    @Override
    public void readCreditAcc(CreditAccount creditAcc) {
        System.out.println(creditAcc);
    }

    /**
     * обновление платежного счета
     * @param creditAcc экземпляр класса CreditAccount
     * @param payAcc новый платежный счет
     * */
    @Override
    public void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc) {
        creditAcc.setPaymentAccount(payAcc);
    }
}
