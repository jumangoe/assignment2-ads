import java.util.*;

public class Task7 {

    static BankAccount FindAccount(LinkedList<BankAccount> accounts,String name){
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).username.equalsIgnoreCase(name)){
                return accounts.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        LinkedList<BankAccount> accounts=new LinkedList<BankAccount>();
        Stack<String> history=new Stack<String>();
        Queue<AccountRequest> requests=new LinkedList<AccountRequest>();
        Queue<String> billQueue=new LinkedList<String>();

        while(true){
            System.out.println("\n1 Bank");
            System.out.println("2 ATM");
            System.out.println("3 Admin");
            System.out.println("4 Exit");
            int choice=input.nextInt();
            input.nextLine();

            // BANK
            if(choice==1){
                System.out.println("1 Request account");
                System.out.println("2 Deposit");
                System.out.println("3 Withdraw");
                int b=input.nextInt();
                input.nextLine();

                if(b==1){
                    System.out.print("Number: ");
                    int num=input.nextInt();
                    input.nextLine();

                    System.out.print("Name: ");
                    String name=input.nextLine();

                    System.out.print("Balance: ");
                    double bal=input.nextDouble();
                    input.nextLine();

                    requests.add(new AccountRequest(num,name,bal));
                    System.out.println("Request sent");
                }

                else if(b==2){
                    System.out.print("Name: ");
                    String name=input.nextLine();

                    BankAccount acc=FindAccount(accounts,name);
                    if(acc!=null){
                        System.out.print("Amount: ");
                        double amt=input.nextDouble();
                        input.nextLine();

                        acc.balance=acc.balance+amt;
                        history.push("Deposit "+amt);
                        System.out.println("Done");
                    }
                }

                else if(b==3){
                    System.out.print("Name: ");
                    String name=input.nextLine();

                    BankAccount acc=FindAccount(accounts,name);
                    if(acc!=null){
                        System.out.print("Amount: ");
                        double amt=input.nextDouble();
                        input.nextLine();

                        if(amt<=acc.balance){
                            acc.balance=acc.balance-amt;
                            history.push("Withdraw "+amt);
                            System.out.println("Done");
                        }
                    }
                }
            }

            // ATM
            else if(choice==2){
                System.out.print("Enter name: ");
                String name=input.nextLine();

                BankAccount acc=FindAccount(accounts,name);

                if(acc!=null){
                    System.out.println("1 Balance");
                    System.out.println("2 Withdraw");
                    int a=input.nextInt();
                    input.nextLine();

                    if(a==1){
                        System.out.println("Balance: "+acc.balance);
                    }
                    else if(a==2){
                        System.out.print("Amount: ");
                        double amt=input.nextDouble();
                        input.nextLine();

                        if(amt<=acc.balance){
                            acc.balance=acc.balance-amt;
                            System.out.println("Withdraw done");
                        }
                    }
                }
            }

            // ADMIN
            else if(choice==3){
                System.out.println("1 Process request");
                System.out.println("2 Show requests");
                int a=input.nextInt();
                input.nextLine();

                if(a==1){
                    if(!requests.isEmpty()){
                        AccountRequest r=requests.poll();
                        accounts.add(new BankAccount(r.accountNumber,r.username,r.balance));
                        System.out.println("Account created: "+r.username);
                    }
                }

                else if(a==2){
                    for(AccountRequest r:requests){
                        System.out.println(r.username);
                    }
                }
            }

            else if(choice==4){
                break;
            }
        }
    }
}