package bank.service.impl;

import bank.entity.*;
import bank.service.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserImpl implements UserService {
    private PaymentAccountService payService = new PaymentAccountImpl();
    private CreditAccountService creditService = new CreditAccountImpl();
    private Map<Integer, User> users = new HashMap<Integer, User>();
    public UserImpl(){}
    @Override
    public void setPayService(PaymentAccountService payService) {
        this.payService = payService;
    }

    @Override
    public void setCreditService(CreditAccountService creditService) {
        this.creditService = creditService;
    }

    @Override
    public User createUser(Integer id, String fullName, Date birthDay, String workPlace) {
        return users.put(id, new User(id, fullName, birthDay, workPlace));
    }

    @Override
    public User readUser(Integer id) {
        return users.get(id);
    }

    @Override
    public void updateUserWork(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }

    @Override
    public void getUserInfo(Integer id) {
        System.out.println("\n");
        System.out.println("Payment accounts");
        for (int i = 1; i <= 50; i++){
            PaymentAccount pay = payService.readPayAcc(i);
            if (pay.getUserId() == id ){
                System.out.println("*************");
                System.out.println(pay);
            }
        }
        System.out.println("\n");
        System.out.println("Credit accounts");
        for (int j = 1; j <= 50; j++){
            CreditAccount credit = creditService.readCreditAcc(j);
            if (credit.getUserId() == id ){
                System.out.println("*************");
                System.out.println(credit);
            }
        }
    }

}
