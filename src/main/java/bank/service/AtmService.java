package bank.service;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.utils.Status;

public interface AtmService {
    BankATM createATM(Bank bank, BankOffice office, Integer id, String name, Status status, Integer employeeId,
                      Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost);
    void readATM(BankATM atm);
    void updateATMStatusOfWorking(BankATM atm, Status status);
    void updateATMStatusOfGiving(BankATM atm, Boolean canGiveMoney);
    void updateATMStatusOfDeposit(BankATM atm, Boolean canDepositMoney);
    boolean updateATMMoney(BankATM atm, Bank bank, Double money);
}

