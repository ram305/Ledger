package ledger.models;

public class Balance {
    String bank;
    String customer;
    Integer paymentDone;
    Integer emiLeft;

    public Balance(String bank, String customer, Integer paymentDone, Integer emiLeft) {
        this.bank = bank;
        this.customer = customer;
        this.paymentDone = paymentDone;
        this.emiLeft = emiLeft;
    }

    public Integer getPaymentDone() {
        return paymentDone;
    }

    public Integer getEmiLeft() {
        return emiLeft;
    }
}
