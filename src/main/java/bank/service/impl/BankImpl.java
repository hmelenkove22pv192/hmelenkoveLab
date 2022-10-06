package bank.service.impl;

import bank.entity.Bank;
import bank.service.BankService;

public class BankImpl implements BankService {
    public BankImpl(){}
    /**
     * создание экземпляра класса Bank
     * @param id идентификатор банка
     * @param name название банка
     * */
    @Override
    public Bank createBank(Integer id, String name) {
        return new Bank(id, name);
    }

    /**
     * вывод в консоль экземпляра класса Bank
     * @param bank экземпляр класса Bank
     * */
    @Override
    public void readBank(Bank bank) {
        System.out.println(bank);
    }

    /**
     * обновление названия банка
     * @param bank экземпляр класса Bank
     * @param name новое название банка
     * */
    @Override
    public void updateBankName(Bank bank, String name) {
        bank.setName(name);
    }
}
