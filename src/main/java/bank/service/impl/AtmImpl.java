package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.service.AtmService;
import bank.utils.Status;

import java.util.HashMap;
import java.util.Map;

public class AtmImpl implements AtmService {
    private final Map<Integer, BankATM> atms = new HashMap<>();
    // реализация Singleton
    private static AtmImpl instance; // приватное статическое поле, содержащее одиночный объект
    private AtmImpl(){} // приватный конструктор класса
    public static AtmImpl getInstance(){ // статический создающий метод, который будет использоваться для получения одиночки
        if(instance == null){
            instance = new AtmImpl();
        }
        return instance;
    }

    @Override
    public BankATM createATM(Bank bank, BankOffice office, Integer id, String name, Status status, Integer employeeId,
                             Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost) {
        bank.setCountATM(bank.getCountATM() + 1);
        office.setCountATM(office.getCountATM() + 1);
        return atms.put(id, new BankATM(office, id, name, status, employeeId, canGiveMoney, canDepositMoney, money, cost));
    }

    @Override
    public BankATM readATM(Integer id) {
        return atms.get(id);
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
