package ledger.services;


import ledger.models.Balance;

public interface LoanService {
    void takeLoan(String bank, String customer, Integer principal, Integer years, Integer rti);
    Balance getBalance(String bank, String customer, Integer emi);
    void makePayment(String bank, String customer, Integer lumpSum, Integer emisDone);
}
