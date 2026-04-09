import java.util.LinkedList;
import java.util.Scanner;

public class Task2 {

    static BankAccount FindAccount(LinkedList<BankAccount> accounts, String username) {
        for(int i=0;i<accounts.size();i++) {
            if(accounts.get(i).username.equalsIgnoreCase(username)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    static void AddAccount(LinkedList<BankAccount> accounts, Scanner input) {
        System.out.print("Enter account number: ");
        int accountNumber=input.nextInt();
        input.nextLine();

        System.out.print("Enter username: ");
        String username=input.nextLine();

        System.out.print("Enter balance: ");
        double balance=input.nextDouble();
        input.nextLine();

        BankAccount account=new BankAccount(accountNumber, username, balance);
        accounts.add(account);

        System.out.println("Account added successfully");
    }

    static void ShowAccounts(LinkedList<BankAccount> accounts) {
        if(accounts.isEmpty()) {
            System.out.println("No accounts found");
            return;
        }

        System.out.println("Accounts List:");
        for(int i=0;i<accounts.size();i++) {
            BankAccount account=accounts.get(i);
            System.out.println((i+1)+". "+account.username+" - Balance: "+account.balance);
        }
    }

    static void DepositMoney(LinkedList<BankAccount> accounts, Scanner input) {
        System.out.print("Enter username: ");
        String username=input.nextLine();

        BankAccount account=FindAccount(accounts, username);

        if(account==null) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter deposit amount: ");
        double deposit=input.nextDouble();
        input.nextLine();

        account.balance=account.balance+deposit;

        System.out.println("New balance: "+account.balance);
    }

    static void WithdrawMoney(LinkedList<BankAccount> accounts, Scanner input) {
        System.out.print("Enter username: ");
        String username=input.nextLine();

        BankAccount account=FindAccount(accounts, username);

        if(account==null) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter withdraw amount: ");
        double withdraw=input.nextDouble();
        input.nextLine();

        if(withdraw>account.balance) {
            System.out.println("Not enough balance");
            return;
        }

        account.balance=account.balance-withdraw;

        System.out.println("New balance: "+account.balance);
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        LinkedList<BankAccount> accounts=new LinkedList<BankAccount>();

        while(true) {
            System.out.println("\n1. Add new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice=input.nextInt();
            input.nextLine();

            if(choice==1) {
                AddAccount(accounts, input);
            }
            else if(choice==2) {
                ShowAccounts(accounts);
            }
            else if(choice==3) {
                DepositMoney(accounts, input);
            }
            else if(choice==4) {
                WithdrawMoney(accounts, input);
            }
            else if(choice==5) {
                System.out.println("Program finished");
                break;
            }
            else {
                System.out.println("Invalid option");
            }
        }

        input.close();
    }
}