package bank.service;

import bank.entity.Bank;
import bank.entity.BankATM;

public interface AtmService {
    void changeStatus (BankATM bankATM, Integer newStatus);
    void getMoney(BankATM bankATM, Bank bank);
}