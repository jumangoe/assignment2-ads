import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Task5 {

    static void AddRequest(Queue<AccountRequest> accountRequests, Scanner input) {
        System.out.print("Enter account number: ");
        int accountNumber=input.nextInt();
        input.nextLine();

        System.out.print("Enter username: ");
        String username=input.nextLine();

        System.out.print("Enter initial balance: ");
        double balance=input.nextDouble();
        input.nextLine();

        accountRequests.add(new AccountRequest(accountNumber, username, balance));
        System.out.println("Request added: "+username);
    }

    static void ProcessRequest(Queue<AccountRequest> accountRequests, LinkedList<BankAccount> accounts) {
        if(accountRequests.isEmpty()) {
            System.out.println("No requests to process");
            return;
        }

        AccountRequest request=accountRequests.poll();

        BankAccount account=new BankAccount(request.accountNumber, request.username, request.balance);
        accounts.add(account);

        System.out.println("Processed account: "+request.username);
    }

    static void ShowRequests(Queue<AccountRequest> accountRequests) {
        if(accountRequests.isEmpty()) {
            System.out.println("No pending requests");
            return;
        }

        System.out.println("Pending requests:");
        for(AccountRequest request:accountRequests) {
            System.out.println(request.username+" (Balance: "+request.balance+")");
        }
    }

    static void ShowAccounts(LinkedList<BankAccount> accounts) {
        if(accounts.isEmpty()) {
            System.out.println("No accounts");
            return;
        }

        System.out.println("Approved accounts:");
        for(int i=0;i<accounts.size();i++) {
            BankAccount acc=accounts.get(i);
            System.out.println((i+1)+". "+acc.username+" - "+acc.balance);
        }
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        Queue<AccountRequest> accountRequests=new LinkedList<AccountRequest>();
        LinkedList<BankAccount> accounts=new LinkedList<BankAccount>();

        while(true) {
            System.out.println("\n1. Add account request");
            System.out.println("2. Process next request");
            System.out.println("3. Show pending requests");
            System.out.println("4. Show approved accounts");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice=input.nextInt();
            input.nextLine();

            if(choice==1) {
                AddRequest(accountRequests, input);
            }
            else if(choice==2) {
                ProcessRequest(accountRequests, accounts);
            }
            else if(choice==3) {
                ShowRequests(accountRequests);
            }
            else if(choice==4) {
                ShowAccounts(accounts);
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