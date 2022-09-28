package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;

public interface BankOfficeService {
    Boolean addATM(BankOffice office, Bank bank, Integer atmCount);
    void changeWorkStatus(BankOffice office, Integer flag);
}