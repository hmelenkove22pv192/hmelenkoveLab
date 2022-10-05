package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.service.AtmService;

public class AtmImpl implements AtmService {
    public AtmImpl(){}
    @Override
    public BankATM createATM(Bank bank, BankOffice office, Integer id, String name, Integer status, Integer employeeId,
                             Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost) {
        bank.setCountATM(bank.getCountATM() + 1);
        return new BankATM(office, id, name, status, employeeId, canGiveMoney, canDepositMoney, money, cost);
    }

    @Override
    public void readATM(BankATM atm) {
        System.out.println("id: " + atm.getId());
        System.out.println("name: " + atm.getName());
        System.out.println("address: " + atm.getAddress());
        System.out.println("status: " + atm.getStatus());
        System.out.println("employeeId: " + atm.getEmployeeId());
        System.out.println("canGiveMoney: " + atm.getCanGiveMoney());
        System.out.println("canDepositMoney: " + atm.getCanDepositMoney());
        System.out.println("money: " + atm.getMoney());
        System.out.println("cost: " + atm.getCost());
    }
    @Override
    public void updateATMStatusOfWorking(BankATM atm, Integer status) {
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
    @Override
    public void deleteATM(BankATM atm, Bank bank) {
        bank.setCountATM(bank.getCountATM() - 1);
        atm = null;
    }
}
