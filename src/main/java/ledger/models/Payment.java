package ledger.models;

public class Payment implements Comparable<Payment> {
    Integer emisDone;
    Integer lumpSum;

    public Payment(int emisDone, int lumpSum) {
        this.emisDone = emisDone;
        this.lumpSum = lumpSum;
    }

    public int compareTo(Payment other) {
        return this.emisDone-other.emisDone;
    }
}
