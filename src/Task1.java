import java.util.LinkedList;
import java.util.Scanner;

public class Task1 {

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
            System.out.println((i+1)+". "+account.username+" – Balance: "+account.balance);
        }
    }

    static void SearchAccount(LinkedList<BankAccount> accounts, Scanner input) {
        System.out.print("Enter username to search: ");
        String searchName=input.nextLine();

        boolean found=false;

        for(int i=0;i<accounts.size();i++) {
            BankAccount account=accounts.get(i);
            if(account.username.equalsIgnoreCase(searchName)) {
                System.out.println("Account found:");
                System.out.println("Account Number: "+account.accountNumber);
                System.out.println("Username: "+account.username);
                System.out.println("Balance: "+account.balance);
                found=true;
                break;
            }
        }

        if(!found) {
            System.out.println("Account not found");
        }
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        LinkedList<BankAccount> accounts=new LinkedList<BankAccount>();

        while(true) {
            System.out.println("\n1. Add new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Search account by username");
            System.out.println("4. Exit");
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
                SearchAccount(accounts, input);
            }
            else if(choice==4) {
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