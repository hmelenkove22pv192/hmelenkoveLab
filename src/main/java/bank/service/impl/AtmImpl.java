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
    @Override
    public BankATM createATM(Bank bank, BankOffice office, Integer id, String name, Status status, Integer employeeId,
                             Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost) {
        bank.setCountATM(bank.getCountATM() + 1);
        return new BankATM(office, id, name, status, employeeId, canGiveMoney, canDepositMoney, money, cost);
    }

    /**
     * вывод в консоль экземпляра класса BankATM
     * */
    @Override
    public void readATM(BankATM atm) {
        System.out.println(atm);
    }

    /**
     * обновление статуса работы BankATM
     * status - статус работы банкомата (работает/не работает/нет денег)
     * */
    @Override
    public void updateATMStatusOfWorking(BankATM atm, Status status) {
        atm.setStatus(status);
    }

    /**
     * обновление статуса выдачи денег BankATM
     * canGiveMoney - флаг статуса (0 - банкомат не может выдавать деньги, 1 - может выдавать)
     * */
    @Override
    public void updateATMStatusOfGiving(BankATM atm, Boolean canGiveMoney) {
        atm.setCanGiveMoney(canGiveMoney);
    }

    /**
     * обновление статуса вноса денег BankATM
     * canDepositMoney - флаг статуса (0 - банкомат не может принимать деньги, 1 - может принимать)
     * */
    @Override
    public void updateATMStatusOfDeposit(BankATM atm, Boolean canDepositMoney) {
        atm.setCanDepositMoney(canDepositMoney);
    }

    /**
     * обновление количества денег в BankATM
     * если в банке общее количество денег больше чем money, обновляем данные и возвращаем true,
     * иначе false
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
