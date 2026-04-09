import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Task3 {

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

        accounts.add(new BankAccount(accountNumber, username, balance));
        System.out.println("Account added successfully");
    }

    static void Deposit(LinkedList<BankAccount> accounts, Stack<String> history, Scanner input) {
        System.out.print("Enter username: ");
        String username=input.nextLine();

        BankAccount account=FindAccount(accounts, username);
        if(account==null) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter deposit amount: ");
        double amount=input.nextDouble();
        input.nextLine();

        account.balance=account.balance+amount;

        String action="Deposit "+amount+" to "+account.username;
        history.push(action);

        System.out.println(action);
    }

    static void Withdraw(LinkedList<BankAccount> accounts, Stack<String> history, Scanner input) {
        System.out.print("Enter username: ");
        String username=input.nextLine();

        BankAccount account=FindAccount(accounts, username);
        if(account==null) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter withdraw amount: ");
        double amount=input.nextDouble();
        input.nextLine();

        if(amount>account.balance) {
            System.out.println("Not enough balance");
            return;
        }

        account.balance=account.balance-amount;

        String action="Withdraw "+amount+" from "+account.username;
        history.push(action);

        System.out.println(action);
    }

    static void PayBill(Stack<String> history, Scanner input) {
        System.out.print("Enter bill name: ");
        String bill=input.nextLine();

        System.out.print("Enter amount: ");
        double amount=input.nextDouble();
        input.nextLine();

        String action="Bill payment "+amount+" for "+bill;
        history.push(action);

        System.out.println(action);
    }

    static void ShowLast(Stack<String> history) {
        if(history.isEmpty()) {
            System.out.println("No transactions");
            return;
        }

        System.out.println("Last transaction: "+history.peek());
    }

    static void Undo(Stack<String> history) {
        if(history.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }

        String removed=history.pop();
        System.out.println("Undo -> "+removed+" removed");
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        LinkedList<BankAccount> accounts=new LinkedList<BankAccount>();
        Stack<String> history=new Stack<String>();

        while(true) {
            System.out.println("\n1. Add account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Pay bill");
            System.out.println("5. Show last transaction");
            System.out.println("6. Undo last transaction");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice=input.nextInt();
            input.nextLine();

            if(choice==1) {
                AddAccount(accounts, input);
            }
            else if(choice==2) {
                Deposit(accounts, history, input);
            }
            else if(choice==3) {
                Withdraw(accounts, history, input);
            }
            else if(choice==4) {
                PayBill(history, input);
            }
            else if(choice==5) {
                ShowLast(history);
            }
            else if(choice==6) {
                Undo(history);
            }
            else if(choice==7) {
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