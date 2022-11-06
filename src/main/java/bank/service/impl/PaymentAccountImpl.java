package bank.service.impl;

import bank.entity.Bank;
import bank.entity.Employee;
import bank.entity.PaymentAccount;
import bank.entity.User;
import bank.service.PaymentAccountService;

import java.util.Map;

public class PaymentAccountImpl implements PaymentAccountService {
    private Map<Integer, PaymentAccount> pays;

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
