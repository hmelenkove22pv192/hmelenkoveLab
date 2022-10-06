package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.service.AtmService;
import bank.utils.Status;

public class AtmImpl implements AtmService {
    public AtmImpl(){}
    @Override
    public BankATM createATM(Bank bank, BankOffice office, Integer id, String name, Status status, Integer employeeId,
                             Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost) {
        bank.setCountATM(bank.getCountATM() + 1);
        return new BankATM(office, id, name, status, employeeId, canGiveMoney, canDepositMoney, money, cost);
    }

    @Override
    public void readATM(BankATM atm) {
        System.out.println(atm);
    }
    @Override
    public void updateATMStatusOfWorking(BankATM atm, Status status) {
        atm.setStatus(status);
    }
    @Override
    public void updateATMStatusOfGiving(BankATM atm, Boolean canGiveMoney) {
        atm.setCanGiveMoney(canGiveMoney);
    }
    @Override
    public void updateATMStatusOfDeposit(BankATM atm, Boolean canDepositMoney) {
        atm.setCanDepositMoney(canDepositMoney);
    }
    @Override
    public boolean updateATMMoney(BankATM atm, Bank bank, Double money) {
        if (bank.getMoney() > money){
            atm.setMoney(money);
            return true;
        }
        else return false;
    }
}
