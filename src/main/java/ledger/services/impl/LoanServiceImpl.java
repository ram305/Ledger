package ledger.services.impl;

import ledger.models.Balance;
import ledger.models.Loan;
import ledger.services.LoanService;

import java.util.HashMap;
import java.util.Map;

public class LoanServiceImpl implements LoanService {
    // customer - { (bank, loan) }
    Map<String, Map<String, Loan>> loans;

    public LoanServiceImpl() {
        this.loans = new HashMap<>();
    }

    public void takeLoan(String bank, String customer, Integer principal, Integer years, Integer rti) {
        Loan loan = new Loan(bank, principal, years, rti);
        loans.computeIfAbsent(customer, k -> new HashMap<>());
        loans.get(customer).put(bank, loan);
    }

    public void makePayment(String bank, String customer, Integer lumpSum, Integer emisDone) {
        Loan loan = loans.get(customer).get(bank);
        loan.makePayment(emisDone, lumpSum);
    }

    public Balance getBalance(String bank, String customer, Integer emi) {
        Loan loan = loans.get(customer).get(bank);
        int amountPaid = loan.amountPaidTillEMI(emi);
        return new Balance(bank, customer, amountPaid, loan.getEmisLeft(amountPaid));
    }
}
