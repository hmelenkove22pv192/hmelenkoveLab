package bank.service.impl;

import bank.entity.*;
import bank.service.CreditAccountService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreditAccountImpl implements CreditAccountService {
    private Map<Integer, CreditAccount> credits = new HashMap<Integer, CreditAccount>();
    public CreditAccountImpl(){}

    @Override
    public CreditAccount createCreditAcc(Bank bank, User user, Employee employee,
                                         PaymentAccount paymentAccount, Integer id, Date startDate,
                                         Date endDate, Integer countMonth, Double creditSum, Double monthPay) {
        return credits.put(id, new CreditAccount(bank, user, employee, paymentAccount, id, startDate,
                endDate, countMonth, creditSum, monthPay));
    }

    @Override
    public CreditAccount readCreditAcc(Integer id) {
        return credits.get(id);
    }

    @Override
    public void updateCreditPayAcc(CreditAccount creditAcc, PaymentAccount payAcc) {
        creditAcc.setPaymentAccount(payAcc);
    }
}
