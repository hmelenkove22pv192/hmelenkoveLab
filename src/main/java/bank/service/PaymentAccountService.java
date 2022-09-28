package bank.service;

import bank.entity.Bank;
import bank.entity.PaymentAccount;

public interface PaymentAccountService {
    void addMoney(PaymentAccount payAcc, Double money) ;
    Boolean subtractMoney(PaymentAccount payAcc, Double money);
}