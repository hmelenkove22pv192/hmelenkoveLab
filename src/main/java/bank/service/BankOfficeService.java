package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.utils.Status;

public interface BankOfficeService {
    BankOffice createOffice(Bank bankInstance, Integer id, String name, String address, Status status,
                                   Boolean canSetATM, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, Double money, Double cost);
    void readOffice(BankOffice office);
    void updateOfficeStatusOfWorking(BankOffice office, Status status);
    void updateOfficeStatusOfGiving(BankOffice office, Boolean canGiveMoney);
    void updateOfficeStatusOfDeposit(BankOffice office, Boolean canDepositMoney);
    void updateOfficeStatusOfCredit(BankOffice office, Boolean canTakeCredit);
    void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetATM);
}