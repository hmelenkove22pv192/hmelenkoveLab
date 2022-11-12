package bank.utils;

public class Constants {
    public static final int OFFICES_IN_ONE_BANK = 3;
    public static final int ATMS_IN_ONE_OFFICE = 3;
    public static final int EMPLOYEES_IN_ONE_OFFICE = 5;
    public static final int USERS_IN_ONE_BANK = 5;
    public static final int PAYS_AND_CREDITS_IN_ONE_USER = 2;
    public static final int BANKS_COUNT = 5;
    public static final int OFFICES_COUNT = OFFICES_IN_ONE_BANK * BANKS_COUNT;
    public static final int ATMS_COUNT = ATMS_IN_ONE_OFFICE * BANKS_COUNT * OFFICES_IN_ONE_BANK;
    public static final int EMPLOYEES_COUNT = EMPLOYEES_IN_ONE_OFFICE * BANKS_COUNT * OFFICES_IN_ONE_BANK;
    public static final int USERS_COUNT = USERS_IN_ONE_BANK * BANKS_COUNT;
    public static final int PAYS_AND_CREDITS_COUNT = PAYS_AND_CREDITS_IN_ONE_USER * BANKS_COUNT * USERS_IN_ONE_BANK;


}
