package bank.service;

import bank.entity.Bank;

public interface BankService {
    /**
     * создание экземпляра класса Bank
     * @param id идентификатор банка
     * @param name название банка
     * */
    Bank createBank(Integer id, String name);
    /**
     * вывод в консоль экземпляра класса Bank
     * @param bank экземпляр класса Bank
     * */
    void readBank(Bank bank);
    /**
     * обновление названия банка
     * @param bank экземпляр класса Bank
     * @param name новое название банка
     * */
    void updateBankName(Bank bank, String name);
}