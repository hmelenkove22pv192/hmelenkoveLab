package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankOfficeService;
import bank.utils.Status;

public class BankOfficeImpl implements BankOfficeService {

    public BankOfficeImpl(){}
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
     * @param office экземпляр класса BankOffice
     * */
    @Override
    public void readOffice(BankOffice office) {
        System.out.println(office);
    }

    /**
     * обновление статуса работы BankOffice
     * @param office экземпляр класса BankOffice
     * @param status статус работы офиса (работает/не работает)
     * */
    @Override
    public void updateOfficeStatusOfWorking(BankOffice office, Status status) {
        office.setStatus(status);
    }

    /**
     * обновление статуса выдачи денег BankOffice
     * @param office экземпляр класса BankOffice
     * @param canGiveMoney флаг статуса (0 - офис не может выдавать деньги, 1 - может выдавать)
     * */
    @Override
    public void updateOfficeStatusOfGiving(BankOffice office, Boolean canGiveMoney) {
        office.setCanGiveMoney(canGiveMoney);
    }

    /**
     * обновление статуса вноса денег BankOffice
     * @param office экземпляр класса BankOffice
     * @param canDepositMoney флаг статуса (0 - офис не может принимать деньги, 1 - может принимать)
     * */
    @Override
    public void updateOfficeStatusOfDeposit(BankOffice office, Boolean canDepositMoney) {
        office.setCanDepositMoney(canDepositMoney);
    }

    /**
     * обновление статуса выдачи кредитов BankOffice
     * @param office экземпляр класса BankOffice
     * @param canTakeCredit флаг статуса (0 - офис не может выдавать кредиты, 1 - может выдавать кредиты)
     * */
    @Override
    public void updateOfficeStatusOfCredit(BankOffice office, Boolean canTakeCredit) {
        office.setCanTakeCredit(canTakeCredit);
    }

    /**
     * обновление статуса установки банкоматов BankOffice
     * @param office экземпляр класса BankOffice
     * @param canSetATM флаг статуса (0 - офис не может поставить банкомат, 1 - может поставить)
     * */
    @Override
    public void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetATM) {
        office.setCanSetATM(canSetATM);
    }

}
