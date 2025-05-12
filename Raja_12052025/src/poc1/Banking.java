package poc1;

/*
    Concepts Covered:
    ----------------------------
    Static vs instance variables
    Variable scope and shadowing
    this keyword usage
    Basic OOP principles
    Aggregating totals using shared (static) variables

 */
public class Banking {

    private static long accountNumberGenerator = 10000;

    //  CREATE ACCOUNT
    public static BankAccount createAccount(String name, double balance){
        return new BankAccount(++accountNumberGenerator, name, balance);
    }


    public static void main(String[] args) {

        //  SHOWING DETAILS OF BANK
        System.out.println("NO OF ACCOUNTS: "+BankAccount.getNoOfAccounts());
        System.out.println("Total Funds in the Bank: "+BankAccount.getTotalAmount());

        //  CREATING ACCOUNTS
        BankAccount user1 = createAccount("Raju", 1000);
        BankAccount user2 = createAccount("Anil", 1000);

        // SHOWING DETAILS OF BANK
        System.out.println("--------------------------------------------------------");
        System.out.println("NO OF ACCOUNTS: "+BankAccount.getNoOfAccounts());
        System.out.println("Total Funds in the Bank: "+BankAccount.getTotalAmount());
        System.out.println("--------------------------------------------------------");


        //  DEPOSIT FUNDS
        user1.deposit(5000);
        System.out.println(user1);
        user2.deposit(9000);
        System.out.println(user2);


        //  WITHDRAW FUNDS
        user1.withdraw(1000);
        System.out.println(user1);
        user2.withdraw(5000);
        System.out.println(user2);


        //  CREATING ACCOUNTS
        BankAccount user3 = createAccount("Hari", 1000);
        BankAccount user4 = createAccount("Jai", 1000);

        //  TRANSFER FUNDS
        user1.transfer(user2, 1000);
        System.out.println(user1);
        System.out.println(user2);


        // SHOWING DETAILS OF BANK
        System.out.println("--------------------------------------------------------");
        System.out.println("NO OF ACCOUNTS: "+BankAccount.getNoOfAccounts());
        System.out.println("Total Funds in the Bank: "+BankAccount.getTotalAmount());
        System.out.println("--------------------------------------------------------");
    }
}
