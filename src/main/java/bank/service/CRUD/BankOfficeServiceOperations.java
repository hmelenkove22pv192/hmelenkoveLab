package bank.service.CRUD;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankOfficeService;

public interface BankOfficeServiceOperations extends BankOfficeService {
    @Override
    public default Boolean addATM(BankOffice office, Bank bank, Integer atmCount) {
        if (bank.getCountATM() > atmCount && office.getCanSetATM()){
            office.setCountATM(office.getCountATM() + atmCount);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }

    @Override
    public default void changeWorkStatus(BankOffice office, Integer flag) {
        office.setStatus(flag);
    }
}
