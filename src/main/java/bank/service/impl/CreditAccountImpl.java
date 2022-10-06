package bank.service.impl;

import bank.entity.*;
import bank.service.CreditAccountService;

import java.util.Date;

public class CreditAccountImpl implements CreditAccountService {
    public CreditAccountImpl(){}
    @Override
    public CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                         PaymentAccount paymentAccount, Integer id, Date startDate,
                                         Date endDate, Integer countMonth, Double creditSum, Double monthPay) {
        return new CreditAccount(bank, user, employee, paymentAccount, id, startDate,
                endDate, countMonth, creditSum, monthPay);
    }

    @Override
    public void readCreditAcc(CreditAccount creditAcc) {
        System.out.println(creditAcc);
    }

    @Override
    public void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc) {
        creditAcc.setPaymentAccount(payAcc);
    }
}
