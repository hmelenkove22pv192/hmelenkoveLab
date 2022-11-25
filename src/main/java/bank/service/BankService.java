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
}