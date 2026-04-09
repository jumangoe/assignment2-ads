public class Task6 {

    public static void main(String[] args) {

        BankAccount[] accounts=new BankAccount[3];

        accounts[0]=new BankAccount(101,"Ali",150000);
        accounts[1]=new BankAccount(102,"Sara",220000);
        accounts[2]=new BankAccount(103,"John",180000);

        System.out.println("Accounts List:");

        for(int i=0;i<accounts.length;i++) {
            System.out.println((i+1)+". "+accounts[i].username+" - Balance: "+accounts[i].balance);
        }
    }
}