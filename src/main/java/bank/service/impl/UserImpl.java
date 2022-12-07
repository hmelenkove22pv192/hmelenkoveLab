package bank.service.impl;

import bank.entity.*;
import bank.service.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static bank.utils.Constants.PAYS_AND_CREDITS_COUNT;

public class UserImpl implements UserService {
    private PaymentAccountService payService = PaymentAccountImpl.getInstance();
    private CreditAccountService creditService = CreditAccountImpl.getInstance();
    private final Map<Integer, User> users = new HashMap<>();

    // реализация Singleton
    private static UserImpl instance; // приватное статическое поле, содержащее одиночный объект
    private UserImpl(){} // приватный конструктор класса
    public static UserImpl getInstance(){ // статический создающий метод, который будет использоваться для получения одиночки
        if(instance == null){
            instance = new UserImpl();
        }
        return instance;
    }
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
    public void getUserPaysInfo(Integer id) throws IOException {
        System.out.println("\n");
        // очищаем файл от данных прошлого запуска
        try(FileWriter writer = new FileWriter("pays.txt", false))
        {
            writer.write('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter("pays.txt", true))
        {
            // запись в файл платежных счетов
            writer.write("Pays accounts: \n");
            for (int i = 1; i <= PAYS_AND_CREDITS_COUNT; i++){
                PaymentAccount pay = payService.readPayAcc(i);
                if (Objects.equals(pay.getUserId(), id)){
                    writer.write(pay.toString());
                    writer.flush();
                }
            }

            // запись в файл кредитов
            boolean isUserHasCredits = false;
            writer.write("Credit accounts: \n");
            for (int i = 1; i <= PAYS_AND_CREDITS_COUNT; i++){
                CreditAccount credit = creditService.readCreditAcc(i);
                if (credit != null){
                    if (Objects.equals(credit.getUserId(), id)){
                        isUserHasCredits = true;
                        writer.write(credit.toString());
                        writer.flush();
                    }
                }
            }
            if (!isUserHasCredits){
                writer.write("User has not credits");
                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
