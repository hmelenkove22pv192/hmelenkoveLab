package bank.service.impl;

import bank.entity.*;
import bank.service.CreditAccountService;

import java.util.Date;

public class CreditAccountImpl implements CreditAccountService {
    public CreditAccountImpl(){}
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
    @Override
    public CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                         PaymentAccount paymentAccount, Integer id, Date startDate,
                                         Date endDate, Integer countMonth, Double creditSum, Double monthPay) {
        return new CreditAccount(bank, user, employee, paymentAccount, id, startDate,
                endDate, countMonth, creditSum, monthPay);
    }

    /**
     * вывод в консоль экземпляра класса CreditAccount
     * */
    @Override
    public void readCreditAcc(CreditAccount creditAcc) {
        System.out.println(creditAcc);
    }

    /**
     * обновление платежного счета
     * creditAcc - экземпляр класса CreditAccount
     * payAcc - новый платежный счет
     * */
    @Override
    public void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc) {
        creditAcc.setPaymentAccount(payAcc);
    }
}
