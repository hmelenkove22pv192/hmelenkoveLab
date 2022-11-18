package bank.service.impl;

import bank.entity.*;
import bank.service.*;
import bank.utils.Status;
import bank.utils.UserInputException;

import java.util.*;

import static bank.utils.Constants.*;
import static bank.utils.UtilsFunctions.*;

public class UserImpl implements UserService {
    private PaymentAccountService payService = PaymentAccountImpl.getInstance();
    private CreditAccountService creditService = CreditAccountImpl.getInstance();
    private BankService bankService = BankImpl.getInstance();
    private BankOfficeService officeService = BankOfficeImpl.getInstance();
    private EmployeeService employeeService = EmployeeImpl.getInstance();
    private AtmService atmService = AtmImpl.getInstance();
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
    public void searchPlaceForUserCredit(Double moneyForCredit) throws UserInputException {
        Scanner in = new Scanner(System.in);
        // локально сохраняем массив с копией всех банков
        Map<Integer, Bank> banks = new HashMap<>();
        for (int i = 1; i <= BANKS_COUNT; i++) {
            banks.put(i, bankService.readBank(i));
        }

        boolean isBankWasFound = false;
        while (!isBankWasFound && banks.size() != 0){
            // выбор клиентом самого лучшего и выгодного банка (низкая процентная ставка и высокий рейтинг)
            System.out.println("Choose bank, input the number");
            for (int i = 1; i <= banks.size(); i++) {
                Bank bank = banks.get(i);
                System.out.printf("%d - %s: rating = %d, interestRate = %.2f \n",
                        i, bank.getName(), bank.getRating(), bank.getInterestRate());
            }
            int bankId = in.nextInt();
            if (bankId <= 0 || bankId > BANKS_COUNT){
                throw new UserInputException("Input a number in the range 1-" + BANKS_COUNT);
            }
            System.out.println("Bank for client:");
            System.out.println(banks.get(bankId));
            System.out.println("\n");

            List<Integer> idList = new ArrayList<>();
            // локально сохраняем массив с копией всех оффисов в банке
            Map<Integer, BankOffice> offices = new HashMap<>();
            for (int i = 1; i <= OFFICES_COUNT; i++) {
                BankOffice office = officeService.readOffice(i);
                if (Objects.equals(office.getBankId(), banks.get(bankId).getId())){
                    offices.put(offices.size() + 1, office);
                }
            }
            // поиск офиса по критериям: офис должен работать, в нем
            //должны выдавать кредит, запрашиваемая сумма должна быть в этом
            //офисе
            boolean isOfficeWasFound = false;
            while (!isOfficeWasFound && offices.size() != 0) {
                System.out.println("Choose office, input the number");
                int j = 1;
                while (j <= offices.size()) {
                    BankOffice office = offices.get(j);
                        if (office.getStatus() == Status.WORK &&
                                office.getCanTakeCredit() &&
                                office.getMoney() > moneyForCredit){
                            System.out.printf("%d - %s, address: %s \n", j, office.getName(), office.getAddress());
                            idList.add(j);
                        }
                        else {
                            offices.remove(j);
                            offices = calculateBankOfficeId(j, offices);
                            j--;
                        }
                    j++;
                }
                if (offices.size() == 0){
                    System.out.println("Oh, no! In this bank all offices are no suitable :( " +
                            "\n Please, try another bank! \n");
                    banks.remove(bankId);
                    banks = calculateBankId(bankId, banks);
                }
                else {
                    Integer officeId = in.nextInt();
                    if (!idList.contains(officeId)){
                        throw new UserInputException("Input a suitable office number");
                    }
                    System.out.println("Office for client:");
                    System.out.println(offices.get(officeId));
                    System.out.println("\n");

                    idList.clear();
                    // поиск сотрудника, который умеет выдавать кредиты
                    boolean isSomeoneCanGiveCredits = false;
                    int badEmployees = 0;
                    while (!isSomeoneCanGiveCredits && badEmployees != EMPLOYEES_IN_ONE_OFFICE){
                        System.out.println("Choose employee, input the number");
                        for (int i = 1; i <= EMPLOYEES_COUNT; i++) {
                            Employee employee = employeeService.readEmployee(i);
                            if (Objects.equals(employee.getOfficeId(), offices.get(officeId).getId())){
                                if (employee.getCanGiveCredit()){
                                    System.out.printf("%d - %s, job: %s \n", i, employee.getFullName(), employee.getJobTitle());
                                    isSomeoneCanGiveCredits = true;
                                    idList.add(i);
                                }
                                else {
                                    badEmployees += 1;
                                }
                            }
                        }
                    }
                    if (!isSomeoneCanGiveCredits){
                        System.out.println("Oh, no! In this office all employees are no suitable :(" +
                                "\n Please, try another office! \n");
                        offices.remove(officeId);
                        offices = calculateBankOfficeId(officeId, offices);
                        if (offices.size() == 0){
                            System.out.println("Sorry, in this bank all offices are no suitable  " +
                                    "\n Please, try another bank! \n");
                            banks.remove(bankId);
                            banks = calculateBankId(bankId, banks);
                        }
                    }
                    else {
                        int employeeId = in.nextInt();
                        if (!idList.contains(employeeId)){
                            throw new UserInputException("Input a suitable employee number");
                        }
                        System.out.println("Employee for client:");
                        System.out.println(employeeService.readEmployee(employeeId));
                        System.out.println("\n");

                        idList.clear();
                        // поиск банкомата для выдачи денег
                        boolean isATMWasFound = false;
                        int badATMS = 0;
                        while (!isATMWasFound && badATMS != ATMS_IN_ONE_OFFICE){
                            System.out.println("Choose ATM, input the number");
                            for (int i = 1; i <= ATMS_COUNT; i++) {
                                BankATM atm = atmService.readATM(i);
                                if (Objects.equals(atm.getOfficeId(), offices.get(officeId).getId())){
                                    if (atm.getStatus() == Status.WORK
                                            && atm.getCanGiveMoney()
                                            && atm.getMoney() >= moneyForCredit){
                                        System.out.printf("%d - %s, address: %s \n", i, atm.getName(), atm.getAddress());
                                        isOfficeWasFound = true;
                                        isBankWasFound = true;
                                        isATMWasFound = true;
                                        idList.add(i);
                                    }
                                    else {
                                        badATMS += 1;
                                    }
                                }
                            }
                        }
                        if (!isATMWasFound){
                            System.out.println("Oh, no! In this office all ATMs are no suitable :(" +
                                    "\n Please, try another office! \n");
                            offices.remove(officeId);
                            offices = calculateBankOfficeId(officeId, offices);

                            if (offices.size() == 0){
                                System.out.println("Sorry, in this bank all offices are no suitable  " +
                                        "\n Please, try another bank! \n");
                                banks.remove(bankId);
                                banks = calculateBankId(bankId, banks);
                            }
                        }
                        else {
                            int atmId = in.nextInt();
                            if (!idList.contains(atmId)) {
                                throw new UserInputException("Input a suitable ATM number");
                            }
                            System.out.println("ATM for client:");
                            System.out.println(atmService.readATM(atmId));
                            System.out.println("\n");
                        }
                    }
                }
            }
        }
        if (banks.size() == 0) {
            throw new UserInputException("Oh, no! There is no suitable banks");
        }
    }

    @Override
    public void giveUserCredit(Integer id, Double moneyForCredit) throws UserInputException {
        searchPlaceForUserCredit(moneyForCredit);
    }
}
