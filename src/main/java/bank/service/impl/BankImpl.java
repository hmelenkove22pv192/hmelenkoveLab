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
        System.out.println(bank);
    }

    @Override
    public void updateBankName(Bank bank, String name) {
        bank.setName(name);
    }
}
