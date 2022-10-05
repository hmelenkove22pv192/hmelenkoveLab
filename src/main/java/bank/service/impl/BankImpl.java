package bank.service.impl;

import bank.entity.Bank;
import bank.service.BankService;

public class BankImpl implements BankService {
    public BankImpl(){}
    @Override
    public Bank createBank(Integer id, String name) {
        return new Bank(id, name);
    }

    @Override
    public void readBank(Bank bank) {
        System.out.println("id: " + bank.getId());
        System.out.println("name: " + bank.getName());
        System.out.println("countOffice: " + bank.getCountOffice());
        System.out.println("countATM: " + bank.getCountATM());
        System.out.println("countEmployees: " + bank.getCountEmployees());
        System.out.println("countClients: " + bank.getCountClients());
        System.out.println("rating: " + bank.getRating());
        System.out.println("money: " + bank.getMoney());
        System.out.println("interestRate: " + bank.getInterestRate());
    }

    @Override
    public void updateBankName(Bank bank, String name) {
        bank.setName(name);
    }

    @Override
    public void deleteBank(Bank bank) {
        bank = null;
    }
}
