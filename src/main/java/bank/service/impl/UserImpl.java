package bank.service.impl;

import bank.entity.*;
import bank.service.*;
import bank.utils.Status;
import bank.utils.UserInputException;

import java.text.SimpleDateFormat;
import java.util.*;

import static bank.utils.Constants.*;

public class UserImpl implements UserService {
    private PaymentAccountService payService = PaymentAccountImpl.getInstance();
    private CreditAccountService creditService = CreditAccountImpl.getInstance();
    private final BankService bankService = BankImpl.getInstance();
    private final BankOfficeService officeService = BankOfficeImpl.getInstance();
    private final EmployeeService employeeService = EmployeeImpl.getInstance();
    private final AtmService atmService = AtmImpl.getInstance();
    private final Map<Integer, User> users = new HashMap<>();

    // реализация Singleton
    private static UserImpl instance; // приватное статическое поле, содержащее одиночный объект

    private UserImpl() {
    } // приватный конструктор класса

    public static UserImpl getInstance() { // статический создающий метод, который будет использоваться для получения одиночки
        if (instance == null) {
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
    public int[] searchPlaceForUserCredit(Double moneyForCredit) throws UserInputException {
        // айди которые вернет функция
        int[] idArray = new int[4];

        // локально сохраняем массив с копией всех банков которые подходят клиенту
        Map<Integer, Bank> banks = new HashMap<>();
        // локально сохраняем массив с копией всех оффисов которые подходят клиенту
        Map<Integer, BankOffice> offices = new HashMap<>();
        // локально сохраняем массив с копией всех сотрудников из подходящего офиса, которые могут
        // выдавать кредит
        Map<Integer, Employee> employees = new HashMap<>();
        // локально сохраняем массив с копией всех atm из подходящего офиса, которые могут
        // выдавать деньги
        Map<Integer, BankATM> atms = new HashMap<>();
        for (int bankIndex = 1; bankIndex <= BANKS_COUNT; bankIndex++) {
            // поиск офиса по критериям: офис должен работать, в нем
            //должны выдавать кредит, запрашиваемая сумма должна быть в этом
            //офисе
            for (int officeIndex = 1; officeIndex <= OFFICES_COUNT; officeIndex++) {
                BankOffice office = officeService.readOffice(officeIndex);
                // оффис из текущего банка?
                if (office.getBankId() == bankIndex) {
                    // удовлетворяет критериям?
                    if (office.getStatus() == Status.WORK &&
                            office.getCanTakeCredit() &&
                            office.getMoney() > moneyForCredit) {
                        // поиск сотрудника, который умеет выдавать кредиты
                        for (int employeeIndex = 1; employeeIndex <= EMPLOYEES_COUNT; employeeIndex++) {
                            Employee employee = employeeService.readEmployee(employeeIndex);
                            // сотрудник в текущем офисе?
                            if (Objects.equals(employee.getOfficeId(), officeIndex)) {
                                // умеет выдавать кредиты?
                                if (employee.getCanGiveCredit()) {
                                    // поиск atm
                                    for (int atmIndex = 1; atmIndex <= ATMS_COUNT; atmIndex++) {
                                        BankATM atm = atmService.readATM(atmIndex);
                                        // atm из текущего офиса?
                                        if (Objects.equals(atm.getOfficeId(), officeIndex)) {
                                            // удовлетворяет условиям?
                                            if (atm.getStatus() == Status.WORK
                                                    && atm.getCanGiveMoney()
                                                    && atm.getMoney() >= moneyForCredit) {
                                                // этот банк еще не сохранен?
                                                if (!banks.containsValue(bankService.readBank(bankIndex))) {
                                                    banks.put(banks.size() + 1, bankService.readBank(bankIndex));
                                                }
                                                // этот офис еще не сохранен?
                                                if (!offices.containsValue(officeService.readOffice(officeIndex))) {
                                                    offices.put(offices.size() + 1, office);
                                                }
                                                // этот сотрудник еще не сохранен?
                                                if (!employees.containsValue(employeeService.readEmployee(employeeIndex))) {
                                                    employees.put(employees.size() + 1, employee);
                                                }
                                                // этот atm еще не сохранен?
                                                if (!atms.containsValue(atmService.readATM(atmIndex))) {
                                                    atms.put(atms.size() + 1, atm);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (banks.size() == 0) {
            throw new UserInputException("Sorry, there is no suitable bank!");
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("You can choose from these banks, input the number");
            for (int i = 1; i <= banks.size(); i++) {
                Bank bank = banks.get(i);
                System.out.printf("%d - %s: rating = %d, interestRate = %.2f \n",
                        i, bank.getName(), bank.getRating(), bank.getInterestRate());
            }
            int bankId = in.nextInt();
            if (!banks.containsValue(banks.get(bankId))) {
                throw new UserInputException("Incorrect input number!");
            }
            System.out.println("Your bank:");
            System.out.println(banks.get(bankId));
            bankId = banks.get(bankId).getId();
            idArray[0] = bankId;
            System.out.println("You can choose from these offices, input the number");
            for (int i = 1; i <= offices.size(); i++) {
                BankOffice office = offices.get(i);
                if (office.getBankId() == bankId) {
                    System.out.printf("%d - %s, address: %s \n", i, office.getName(), office.getAddress());
                }
            }
            int officeId = in.nextInt();
            if (!offices.containsValue(offices.get(officeId))) {
                throw new UserInputException("Incorrect input number!");
            }
            System.out.println("Your office:");
            System.out.println(offices.get(officeId));
            officeId = offices.get(officeId).getId();
            idArray[1] = officeId;
            System.out.println("You can choose from these employees, input the number");
            for (int i = 1; i <= employees.size(); i++) {
                Employee employee = employees.get(i);
                if (employee.getOfficeId() == officeId) {
                    System.out.printf("%d - %s, job: %s \n", i, employee.getFullName(), employee.getJobTitle());
                }
            }
            int employeeId = in.nextInt();
            if (!employees.containsValue(employees.get(employeeId))) {
                throw new UserInputException("Incorrect input number!");
            }
            System.out.println("Your employee:");
            System.out.println(employees.get(employeeId));
            idArray[2] = employees.get(employeeId).getIdEmployee();
            System.out.println("You can choose from these atms, input the number");
            for (int i = 1; i <= atms.size(); i++) {
                BankATM atm = atms.get(i);
                if (atm.getOfficeId() == officeId) {
                    System.out.printf("%d - %s, address: %s \n", i, atm.getName(), atm.getAddress());
                }
            }
            int atmId = in.nextInt();
            if (!atms.containsValue(atms.get(atmId))) {
                throw new UserInputException("Incorrect input number!");
            }
            System.out.println("Your atm:");
            System.out.println(atms.get(atmId));
            idArray[3] = atms.get(atmId).getId();
        }
        return idArray;
    }

    @Override
    public boolean giveUserCredit(Integer id, Double moneyForCredit) throws UserInputException {
        boolean isItDone = false;
        int[] idArray = searchPlaceForUserCredit(moneyForCredit);
        User user = users.get(id);
        Bank bank = bankService.readBank(idArray[0]);
        Scanner in = new Scanner(System.in);
        // проверяем есть ли у клиента счет в банке, если нет, то заводим
        boolean isUserClient = false;
        int payAccId = 0;
        // закомментила, тк решила не создавать счета без юзеров, ведь клиент только 1
//        for (int i = 1; i <= PAYS_AND_CREDITS_COUNT; i++){
//            if (Objects.equals(payService.readPayAcc(i).getUserId(), id)){
//                isUserClient = true;
//                payAccId = payService.readPayAcc(i).getIdPayAcc();
//            }
//        }
        if (user.getCreditRating() < 5000 && bank.getRating() > 50) {
            System.out.println("Sorry, you have too bad rating for our bank! Do you want try again?");
            System.out.println("1 - yes \n");
            System.out.println("0 - no \n");
            if (in.nextInt() == 0) {
                throw new UserInputException("Come back, when you will have a better rating!");
            }
        }
        else {
            if (!isUserClient) {
                System.out.println("You haven't a pay account in our bank! Do you want to create it? \n");
                System.out.println("1 - yes \n");
                System.out.println("0 - no \n");
                if (in.nextInt() == 1) {
                    payAccId = PAYS_AND_CREDITS_COUNT + 1;
                    payService.createPayAcc(bank, user, payAccId);
                } else {
                    throw new UserInputException("Sorry, we can't give your a credit without pay account!");
                }
            }
            System.out.println("Your pay account:");
            System.out.println(payService.readPayAcc(payAccId));
            System.out.println("Almost done! Please input count of months for your credit");
            int countMonths = in.nextInt();
            Calendar dateStart = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Calendar dateEnd = Calendar.getInstance();
            dateEnd.add(Calendar.MONTH, countMonths);
            creditService.createCreditAcc(
                    bank,
                    user,
                    employeeService.readEmployee(idArray[2]),
                    payService.readPayAcc(payAccId),
                    PAYS_AND_CREDITS_COUNT + 1,
                    formatter.format(dateStart.getTime()),
                    formatter.format(dateEnd.getTime()),
                    countMonths,
                    moneyForCredit,
                    moneyForCredit / countMonths);
            System.out.println("Your credit done!");
            System.out.println(creditService.readCreditAcc(PAYS_AND_CREDITS_COUNT + 1));
            isItDone = true;
        }
        return isItDone;
    }
}

