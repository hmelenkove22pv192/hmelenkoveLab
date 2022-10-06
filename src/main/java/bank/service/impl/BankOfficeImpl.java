package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankOfficeService;
import bank.utils.Status;

public class BankOfficeImpl implements BankOfficeService {

    public BankOfficeImpl(){}
    /**
     * создание экземпляра класса BankOffice
     * bank - экземпляр класса Bank
     * id - идентификатор офиса
     * name - название офиса
     * address - адрес офиса
     * status - статус офиса (работает/не работает)
     * canSetATM - можно поставить банкомат (0 - нет, 1 - да)
     * canTakeCredit - может выдать кредит (0 - нет, 1 - да)
     * canGiveMoney - может выдавать деньги (0 - нет, 1 - да)
     * canDepositMoney - может принимать деньги (0 - нет, 1 - да)
     * money - количество денег в офисе
     * cost - стоимость аренды офиса
     * */
    @Override
    public BankOffice createOffice(Bank bank, Integer id, String name, String address, Status status,
                                   Boolean canSetATM, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, Double money, Double cost) {
        bank.setCountOffice(bank.getCountOffice() + 1);
        return new BankOffice(id, name, address, status, canSetATM, canTakeCredit, canGiveMoney,
                canDepositMoney, money, cost);
    }

    /**
     * вывод в консоль экземпляра класса BankOffice
     * */
    @Override
    public void readOffice(BankOffice office) {
        System.out.println(office);
    }

    /**
     * обновление статуса работы BankOffice
     * status - статус работы офиса (работает/не работает)
     * */
    @Override
    public void updateOfficeStatusOfWorking(BankOffice office, Status status) {
        office.setStatus(status);
    }

    /**
     * обновление статуса выдачи денег BankOffice
     * canGiveMoney - флаг статуса (0 - офис не может выдавать деньги, 1 - может выдавать)
     * */
    @Override
    public void updateOfficeStatusOfGiving(BankOffice office, Boolean canGiveMoney) {
        office.setCanGiveMoney(canGiveMoney);
    }

    /**
     * обновление статуса вноса денег BankOffice
     * canDepositMoney - флаг статуса (0 - офис не может принимать деньги, 1 - может принимать)
     * */
    @Override
    public void updateOfficeStatusOfDeposit(BankOffice office, Boolean canDepositMoney) {
        office.setCanDepositMoney(canDepositMoney);
    }

    /**
     * обновление статуса выдачи кредитов BankOffice
     * canTakeCredit - флаг статуса (0 - офис не может выдавать кредиты, 1 - может выдавать кредиты)
     * */
    @Override
    public void updateOfficeStatusOfCredit(BankOffice office, Boolean canTakeCredit) {
        office.setCanTakeCredit(canTakeCredit);
    }

    /**
     * обновление статуса установки банкоматов BankOffice
     * canSetATM - флаг статуса (0 - офис не может поставить банкомат, 1 - может поставить)
     * */
    @Override
    public void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetATM) {
        office.setCanSetATM(canSetATM);
    }

}
