package bank.service;

import bank.entity.Bank;

public interface BankService {
    Bank createBank(Integer id, String name);
    void readBank(Bank bank);
    void updateBankName(Bank bank, String name);
}