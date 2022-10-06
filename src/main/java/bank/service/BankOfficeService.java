package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.utils.Status;

public interface BankOfficeService {
    /**
     * создание экземпляра класса BankOffice
     * @param bank экземпляр класса Bank
     * @param id идентификатор офиса
     * @param name название офиса
     * @param address адрес офиса
     * @param status статус офиса (работает/не работает)
     * @param canSetATM можно поставить банкомат (0 - нет, 1 - да)
     * @param canTakeCredit может выдать кредит (0 - нет, 1 - да)
     * @param canGiveMoney может выдавать деньги (0 - нет, 1 - да)
     * @param canDepositMoney может принимать деньги (0 - нет, 1 - да)
     * @param money количество денег в офисе
     * @param cost стоимость аренды офиса
     * */
    BankOffice createOffice(Bank bank, Integer id, String name, String address, Status status,
                                   Boolean canSetATM, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, Double money, Double cost);
    /**
     * вывод в консоль экземпляра класса BankOffice
     * @param office экземпляр класса BankOffice
     * */
    void readOffice(BankOffice office);
    /**
     * обновление статуса работы BankOffice
     * @param status статус работы офиса (работает/не работает)
     * */
    void updateOfficeStatusOfWorking(BankOffice office, Status status);
    /**
     * обновление статуса выдачи денег BankOffice
     * @param canGiveMoney флаг статуса (0 - офис не может выдавать деньги, 1 - может выдавать)
     * */
    void updateOfficeStatusOfGiving(BankOffice office, Boolean canGiveMoney);
    /**
     * обновление статуса вноса денег BankOffice
     * @param canDepositMoney флаг статуса (0 - офис не может принимать деньги, 1 - может принимать)
     * */
    void updateOfficeStatusOfDeposit(BankOffice office, Boolean canDepositMoney);
    /**
     * обновление статуса выдачи кредитов BankOffice
     * @param canTakeCredit флаг статуса (0 - офис не может выдавать кредиты, 1 - может выдавать кредиты)
     * */
    void updateOfficeStatusOfCredit(BankOffice office, Boolean canTakeCredit);
    /**
     * обновление статуса установки банкоматов BankOffice
     * @param canSetATM флаг статуса (0 - офис не может поставить банкомат, 1 - может поставить)
     * */
    void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetATM);
}