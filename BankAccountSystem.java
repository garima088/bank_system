import java.util.Scanner;
abstract class Account{
    private String name;
    private int accountNumber;
    protected  double balance;

    public Account(String name,int accountNumber , double balance){
        this.name=name;
        this.accountNumber=accountNumber;
        this.balance=balance;

    }



    public String getName(){
        return name;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void display(){
        System.out.println("Name:"+this.name);
        System.out.println("customer account number:"+this.accountNumber);
        System.out.println("Customer balance:"+this.balance);
    }

    public void checkBalance(int accountNumber){
        System.out.println("Account balance is:"+this.balance);
        System.out.println("Account number is :"+this.accountNumber);
    }



}
class SavingAccount extends Account {
    final  double interestRate=1.5;
//    private double balance;

    public SavingAccount(String name,int accountNumber , double balance){
        super(name,accountNumber,balance);
    }


    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            balance += balance * interestRate / 100;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    @Override
    public void withdraw(double balance){
        if(balance>0 && balance<=this.balance){
            this.balance-=balance;
            System.out.println("Amount withdraw successfully:"+balance);
        }else{
            System.out.println("Invalid amount to withdraw:");
        }
    }

}

class KYCBankAccount extends Account{
     int customerId;
     int aadharNumber;
//   double interestRate;

    KYCBankAccount(String name ,int accountNumber,int customerId, int aadharNumber,double balance){

        super(name,accountNumber,balance);
        this.customerId=customerId;
        this.aadharNumber=aadharNumber;

    }

    @Override
    public void display() {
        super.display();
        System.out.println("Customer ID: " + this.customerId);
        System.out.println("Aadhar Number: " + this.aadharNumber);
    }
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
//            balance += balance * interestRate / 100;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Amount withdrawn successfully: " + amount);
        } else {
            System.out.println("Invalid amount to withdraw.");
        }
    }

}



public class BankAccountSystem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Account account = null;

        while (true) {
            System.out.println("1:Create Saving Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.check balance");
            System.out.println("5.KYC Bank account:");
            System.out.println("6.Exit");
            System.out.println("Enter the chice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the customer:");
                    sc.nextLine(); // Consume the leftover newline
                    String name = sc.nextLine();
                    System.out.println("Enter the account number:");
                    int accountNumber = sc.nextInt();
                    System.out.println("Enter the initial balance:");
                    double balance = sc.nextDouble();
                    account = new SavingAccount(name, accountNumber, balance);
                    account.display();
                    break;

                case 2:
                    if (account != null) {
                        System.out.println("Enter the amount to deposit:");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account exists. Please create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.println("Enter the amount to withdraw:");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("No account exists. Please create an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        System.out.println("Enter the account no:");
                        accountNumber =sc.nextInt();
//                        if(accountNumber==AcNumber) {
                            account.checkBalance(accountNumber);
//                        }
                    } else {
                        System.out.println("No account exists. Please create an account first.");
                    }
                    break;
                case 5:
                    System.out.println("Enter the name of the customer:");
                    sc.nextLine(); // Consume the leftover newline
                    name = sc.nextLine();
                    System.out.println("Enter the account number:");
                    accountNumber = sc.nextInt();
                    System.out.println("Enter the customer ID:");
                    int customerId = sc.nextInt();
                    System.out.println("Enter the Aadhar number:");
                    int aadharNumber = sc.nextInt();
                    System.out.println("Enter the initial balance:");
                    balance = sc.nextDouble();
                    account = new KYCBankAccount(name, accountNumber, customerId, aadharNumber, balance);
                    account.display();
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice:");


            }
        }
    }
}




