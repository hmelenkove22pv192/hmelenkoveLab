package bank.service.impl;

import bank.entity.Bank;
import bank.service.BankService;

public class BankImpl implements BankService {
    public BankImpl(){}
    /**
     * создание экземпляра класса Bank
     * id - идентификатор банка
     * name - название банка
     * */
    @Override
    public Bank createBank(Integer id, String name) {
        return new Bank(id, name);
    }

    /**
     * вывод в консоль экземпляра класса Bank
     * */
    @Override
    public void readBank(Bank bank) {
        System.out.println(bank);
    }

    /**
     * обновление названия банка
     * bank - экземпляр класса Bank
     * name - новое название банка
     * */
    @Override
    public void updateBankName(Bank bank, String name) {
        bank.setName(name);
    }
}
