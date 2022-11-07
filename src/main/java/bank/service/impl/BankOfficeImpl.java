package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankOfficeService;
import bank.utils.Status;

import java.util.HashMap;
import java.util.Map;

public class BankOfficeImpl implements BankOfficeService {
    private Map<Integer, BankOffice> offices = new HashMap<Integer, BankOffice>();

    public BankOfficeImpl(){}

    @Override
    public BankOffice createOffice(Bank bank, Integer id, String name, String address, Status status,
                                   Boolean canSetATM, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, Double money, Double cost) {
        bank.setCountOffice(bank.getCountOffice() + 1);
        return offices.put(id, new BankOffice(id, bank.getId(), name, address, status, canSetATM, canTakeCredit,
                canGiveMoney, canDepositMoney, money, cost)) ;
    }

    @Override
    public BankOffice readOffice(Integer id) {
        return offices.get(id);
    }

    @Override
    public void updateOfficeStatusOfWorking(BankOffice office, Status status) {
        office.setStatus(status);
    }

    @Override
    public void updateOfficeStatusOfGiving(BankOffice office, Boolean canGiveMoney) {
        office.setCanGiveMoney(canGiveMoney);
    }

    @Override
    public void updateOfficeStatusOfDeposit(BankOffice office, Boolean canDepositMoney) {
        office.setCanDepositMoney(canDepositMoney);
    }

    @Override
    public void updateOfficeStatusOfCredit(BankOffice office, Boolean canTakeCredit) {
        office.setCanTakeCredit(canTakeCredit);
    }

    @Override
    public void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetATM) {
        office.setCanSetATM(canSetATM);
    }

}
