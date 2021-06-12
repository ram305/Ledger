package ledger.models;

import java.util.LinkedList;

public class Loan {
    String bank;
    Integer principal;
    Integer years;
    Integer rti;
    LinkedList<Payment> payments;
    int totalAmount;
    int monthlyEmiAmount;

    public Loan(String bank, Integer principal, Integer years, Integer rti) {
        this.bank = bank;
        this.principal = principal;
        this.years = years;
        this.rti = rti;
        this.payments = new LinkedList<>();
        this.totalAmount = principal + (int) Math.ceil( principal * years * rti * 0.01);
        this.monthlyEmiAmount = (int) Math.ceil((double)totalAmount/(years*12));
    }

    public void makePayment(int emisDone, int lumpSum) {
        Payment payment = new Payment(emisDone, lumpSum);
        payments.add(payment);
        payments.sort(Payment::compareTo);
    }

    public int amountPaidTillEMI(int emi) {
        int amount = 0;
        for (Payment payment : payments) {
            if (payment.emisDone <= emi) {
                amount += payment.lumpSum;
            }
        }
        int emiAmount = (int)Math.ceil((double) totalAmount/(years*12));
        int amountPaid = amount + emi * emiAmount;
        return Math.min(totalAmount, amountPaid);
    }

    public int getEmisLeft(int amountPaid) {
        int amountLeft = totalAmount - amountPaid;
        return (int) Math.ceil((double) amountLeft/monthlyEmiAmount);
    }

//    private int totalAmount() {
//        return principal + (int) Math.ceil( principal * years * rti * 0.01) ;
//    }
//
//    private int getEMIAmount() {
//        return (int) Math.ceil((double)totalAmount()/(years*12));
//    }
}
