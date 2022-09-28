package bank.service.CRUD;

import bank.entity.Bank;
import bank.entity.BankATM;
import bank.entity.additionalClasses.Status;
import bank.service.AtmService;

import java.util.Objects;

public interface AtmServiceOperations extends AtmService {
    @Override
    public default void changeStatus(BankATM bankATM, Integer newStatus) {
        bankATM.setStatus(newStatus);
    }

    @Override
    public default void getMoney(BankATM bankATM, Bank bank) {
        if (bank.getMoney()/bank.getCountOffice() > 100.000){
            bankATM.setMoney(bankATM.getMoney() + 50.000);
        }
    }
}
