package bank.service;

import bank.entity.Bank;

public interface BankService {
    void addMoney(Bank bank, Double money) ;
    Boolean subtractMoney(Bank bank, Double money);
}