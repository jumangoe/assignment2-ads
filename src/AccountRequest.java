class AccountRequest {
    int accountNumber;
    String username;
    double balance;

    AccountRequest(int accountNumber, String username, double balance) {
        this.accountNumber=accountNumber;
        this.username=username;
        this.balance=balance;
    }
}