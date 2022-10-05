package bank.service;

import bank.entity.Bank;
import bank.entity.PaymentAccount;
import bank.entity.User;

public interface PaymentAccountService {
    PaymentAccount createPayAcc(Bank bank, User user, Integer id);
    void readPayAcc(PaymentAccount paymentAccount);
    void updateMoney(PaymentAccount paymentAccount, Double money);
    void deletePayAcc(PaymentAccount paymentAccount, Bank bank);
}