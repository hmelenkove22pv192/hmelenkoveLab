package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankOfficeService;

public class BankOfficeImpl implements BankOfficeService {

    public BankOfficeImpl(){}

    @Override
    public BankOffice createOffice(Bank bank, Integer id, String name, String address, Integer status,
                                   Boolean canSetATM, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, Double money, Double cost) {
        bank.setCountOffice(bank.getCountOffice() + 1);
        return new BankOffice(bank, id, name, address, status, canSetATM, canTakeCredit, canGiveMoney,
                canDepositMoney, money, cost);
    }

    @Override
    public void readOffice(BankOffice office) {
        System.out.println("id: " + office.getId());
        System.out.println("name: " + office.getName());
        System.out.println("address: " + office.getAddress());
        System.out.println("countATM: " + office.getCountATM());
        System.out.println("status: " + office.getStatus());
        System.out.println("canSetATM: " + office.getCanSetATM());
        System.out.println("canTakeCredit: " + office.getCanTakeCredit());
        System.out.println("canGiveMoney: " + office.getCanGiveMoney());
        System.out.println("canDepositMoney: " + office.getCanDepositMoney());
        System.out.println("money: " + office.getMoney());
        System.out.println("cost: " + office.getCost());
    }

    @Override
    public void updateOfficeStatusOfWorking(BankOffice office, Integer status) {
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

    @Override
    public void deleteOffice(BankOffice office, Bank bank) {
        bank.setCountATM(bank.getCountATM() - 1);
        office = null;
    }
}
