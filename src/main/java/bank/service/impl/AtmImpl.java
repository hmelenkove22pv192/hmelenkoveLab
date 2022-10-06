package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.BankOffice;
import bank.service.AtmService;
import bank.utils.Status;

public class AtmImpl implements AtmService {
    public AtmImpl(){}
    /**
     * создание экземпляра класса BankATM
     * @param bank экземпляр класса Bank
     * @param office экземпляр класса BankOffice
     * @param id идентификатор банкомата
     * @param name название банкомата
     * @param status статус банкомата (работает/не работает/нет денег)
     * @param employeeId идентификатор обслуживающего сотрудника
     * @param canGiveMoney может выдавать деньги (0 - нет, 1 - да)
     * @param canDepositMoney может принимать деньги (0 - нет, 1 - да)
     * @param money количество денег в банкомате
     * @param cost стоимость обслуживания банкомата
     * */
    @Override
    public BankATM createATM(Bank bank, BankOffice office, Integer id, String name, Status status, Integer employeeId,
                             Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost) {
        bank.setCountATM(bank.getCountATM() + 1);
        return new BankATM(office, id, name, status, employeeId, canGiveMoney, canDepositMoney, money, cost);
    }

    /**
     * вывод в консоль экземпляра класса BankATM
     * @param atm экземпляр класса BankATM
     * */
    @Override
    public void readATM(BankATM atm) {
        System.out.println(atm);
    }

    /**
     * обновление статуса работы BankATM
     * @param atm экземпляр класса BankATM
     * @param status статус работы банкомата (работает/не работает/нет денег)
     * */
    @Override
    public void updateATMStatusOfWorking(BankATM atm, Status status) {
        atm.setStatus(status);
    }

    /**
     * обновление статуса выдачи денег BankATM
     * @param atm экземпляр класса BankATM
     * @param canGiveMoney флаг статуса (0 - банкомат не может выдавать деньги, 1 - может выдавать)
     * */
    @Override
    public void updateATMStatusOfGiving(BankATM atm, Boolean canGiveMoney) {
        atm.setCanGiveMoney(canGiveMoney);
    }

    /**
     * обновление статуса вноса денег BankATM
     * @param atm экземпляр класса BankATM
     * @param canDepositMoney флаг статуса (0 - банкомат не может принимать деньги, 1 - может принимать)
     * */
    @Override
    public void updateATMStatusOfDeposit(BankATM atm, Boolean canDepositMoney) {
        atm.setCanDepositMoney(canDepositMoney);
    }

    /**
     * обновление количества денег в BankATM
     * если в банке общее количество денег больше чем money, обновляем данные и возвращаем true,
     * иначе false
     * @param atm экземпляр класса BankATM
     * @param bank экземпляр класса Bank
     * @param money
     * */
    @Override
    public boolean updateATMMoney(BankATM atm, Bank bank, Double money) {
        if (bank.getMoney() > money){
            atm.setMoney(money);
            return true;
        }
        else return false;
    }
}
