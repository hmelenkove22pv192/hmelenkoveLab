package bank.service;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.utils.Status;

public interface AtmService {
    /**
     * создание экземпляра класса BankATM
     * bank - экземпляр класса Bank
     * office - экземпляр класса BankOffice
     * id - идентификатор банкомата
     * name - название банкомата
     * status - статус банкомата (работает/не работает/нет денег)
     * employeeId - идентификатор обслуживающего сотрудника
     * canGiveMoney - может выдавать деньги (0 - нет, 1 - да)
     * canDepositMoney - может принимать деньги (0 - нет, 1 - да)
     * money - количество денег в банкомате
     * cost - стоимость обслуживания банкомата
     * */
    BankATM createATM(Bank bank, BankOffice office, Integer id, String name, Status status, Integer employeeId,
                      Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost);
    /**
     * вывод в консоль экземпляра класса BankATM
     * */
    void readATM(BankATM atm);
    /**
     * обновление статуса работы BankATM
     * status - статус работы банкомата
     * */
    void updateATMStatusOfWorking(BankATM atm, Status status);
    /**
     * обновление статуса выдачи денег BankATM
     * canGiveMoney - флаг статуса (0 - банкомат не может выдавать деньги, 1 - может выдавать)
     * */
    void updateATMStatusOfGiving(BankATM atm, Boolean canGiveMoney);
    /**
     * обновление статуса вноса денег BankATM
     * canDepositMoney - флаг статуса (0 - банкомат не может принимать деньги, 1 - может принимать)
     * */
    void updateATMStatusOfDeposit(BankATM atm, Boolean canDepositMoney);
    /**
     * обновление количества денег в BankATM
     * */
    boolean updateATMMoney(BankATM atm, Bank bank, Double money);
}

