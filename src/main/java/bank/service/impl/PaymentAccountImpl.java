package bank.service.impl;

import bank.entity.*;
import bank.service.PaymentAccountService;

import java.util.HashMap;
import java.util.Map;

public class PaymentAccountImpl implements PaymentAccountService {
    private Map<Integer, PaymentAccount> pays = new HashMap<Integer, PaymentAccount>();

    public PaymentAccountImpl(){}

    @Override
    public PaymentAccount createPayAcc(Bank bank, User user, Integer id) {
        bank.setCountClients(bank.getCountOffice() + 1);
        return pays.put(id, new PaymentAccount(bank, user, id));
    }

    @Override
    public PaymentAccount readPayAcc(Integer id) {
        return pays.get(id);
    }

    @Override
    public void updateMoney(PaymentAccount payAcc, Double money) {
        payAcc.setMoney(money);
    }
}
