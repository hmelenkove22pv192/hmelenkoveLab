package bank.service;

import bank.entity.Bank;
import bank.entity.CreditAccount;
import bank.entity.Employee;

public interface CreditAccountService {
    Boolean openCredit(CreditAccount creditAcc, Employee employee);
}