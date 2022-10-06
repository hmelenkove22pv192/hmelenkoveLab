package bank.service;

import bank.entity.Bank;

public interface BankService {
    /**
     * создание экземпляра класса Bank
     * id - идентификатор банка
     * name - название банка
     * */
    Bank createBank(Integer id, String name);
    /**
     * вывод в консоль экземпляра класса Bank
     * */
    void readBank(Bank bank);
    /**
     * обновление названия банка
     * bank - экземпляр класса Bank
     * name - новое название банка
     * */
    void updateBankName(Bank bank, String name);
}