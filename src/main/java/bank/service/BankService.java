package bank.service;

import bank.entity.Bank;

import java.util.Map;

public interface BankService {
    /**
     * создание экземпляра класса Bank
     * @param id идентификатор банка
     * @param name название банка
     * */
    Bank createBank(Integer id, String name);
    /**
     * возвращает экземпляра класса Bank
     * @param id экземпляра класса Bank
     * */
    Bank readBank(Integer id);
    /**
     * возвращает все экземпляры класса Bank
     * */
    Map<Integer, Bank> getAllBanks();
    /**
     * обновление названия банка
     * @param bank экземпляр класса Bank
     * @param name новое название банка
     * */
    void updateBankName(Bank bank, String name);
}