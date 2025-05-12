package poc1;

public class BankAccount {

    private static int noOfAccounts;
    private static double totalAmount;
    private long accountNumber;
    private String name;
    private double balance;

    public BankAccount(long accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        totalAmount += balance;
        noOfAccounts++;
    }

    //  GETTERS AND SETTERS
    public static int getNoOfAccounts() {
        return noOfAccounts;
    }

    public static void setNoOfAccounts(int noOfAccounts) {
        BankAccount.noOfAccounts = noOfAccounts;
    }

    public static double getTotalAmount() {
        return totalAmount;
    }

    public static void setTotalAmount(double totalAmount) {
        BankAccount.totalAmount = totalAmount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }


    //  OPERATIONS
    public void deposit(double amount){
        if(amount > 0){
            this.setBalance(this.getBalance()+amount);
            totalAmount = totalAmount + amount;
            System.out.println("Deposit Successful");
            return;
        }
        System.out.println("Deposit Unsuccessful");
    }

    public void withdraw(double amount){
        if(amount <= this.getBalance()){
            this.setBalance(this.getBalance()-amount);
            totalAmount = totalAmount - amount;
            System.out.println("Withdraw Successful");
            return;
        }
        System.out.println("Withdraw Unsuccessful");
    }

    public void transfer(BankAccount toAccount, double amount){
        if(amount <= this.getBalance()){
            this.setBalance(getBalance()-amount);
            toAccount.setBalance(toAccount.getBalance()+amount);
            System.out.println("Transfer Successful");
            return;
        }
        System.out.println("Transfer Unsuccessful");
    }

    public void checkBalance(){
        System.out.println("Current Balance: "+getBalance());
    }


}
