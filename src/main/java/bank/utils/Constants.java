package bank.utils;

public class Constants {
    public static int officesInOneBank = 3;
    public static int atmsInOneBank = 3;
    public static int employeesInOneBank = 5;
    public static int usersInOneBank = 5;
    public static int paysAndCreditsInOneBank = 2;
    public static int banksCount = 5;
    public static int officesCount = officesInOneBank * banksCount;
    public static int atmsCount = atmsInOneBank * banksCount * officesInOneBank;
    public static int employeesCount = employeesInOneBank * banksCount * officesInOneBank;
    public static int usersCount = usersInOneBank * banksCount;
    public static int paysAndCreditsCount = paysAndCreditsInOneBank * banksCount * usersInOneBank;


}
