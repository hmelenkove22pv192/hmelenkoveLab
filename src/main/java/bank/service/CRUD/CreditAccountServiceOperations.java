package bank.service.CRUD;

import bank.entity.Bank;
import bank.entity.CreditAccount;
import bank.entity.Employee;
import bank.service.CreditAccountService;

public interface CreditAccountServiceOperations extends CreditAccountService {
    @Override
    public default Boolean openCredit(CreditAccount creditAcc, Employee employee) {
        if ((creditAcc.getCreditSum() > creditAcc.getMoney()) || (!employee.getCanGiveCredit()))
            return Boolean.FALSE;
        creditAcc.setEmployeeId(employee.getIdEmployee());
        creditAcc.setCreditSum(creditAcc.getMoney() + creditAcc.getCreditSum());
        return Boolean.TRUE;
    }
}
