package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankOfficeService;
import bank.utils.Status;

public class BankOfficeImpl implements BankOfficeService {

    public BankOfficeImpl(){}

    @Override
    public BankOffice createOffice(Bank bank, Integer id, String name, String address, Status status,
                                   Boolean canSetATM, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, Double money, Double cost) {
        bank.setCountOffice(bank.getCountOffice() + 1);
        return new BankOffice(id, name, address, status, canSetATM, canTakeCredit, canGiveMoney,
                canDepositMoney, money, cost);
    }

    @Override
    public void readOffice(BankOffice office) {
        System.out.println(office);
    }

    @Override
    public void updateOfficeStatusOfWorking(BankOffice office, Status status) {
        office.setStatus(status);
    }

    @Override
    public void updateOfficeStatusOfGiving(BankOffice office, Boolean canGiveMoney) {
        office.setCanGiveMoney(canGiveMoney);
    }

    @Override
    public void updateOfficeStatusOfDeposit(BankOffice office, Boolean canDepositMoney) {
        office.setCanDepositMoney(canDepositMoney);
    }

    @Override
    public void updateOfficeStatusOfCredit(BankOffice office, Boolean canTakeCredit) {
        office.setCanTakeCredit(canTakeCredit);
    }

    @Override
    public void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetATM) {
        office.setCanSetATM(canSetATM);
    }

}
