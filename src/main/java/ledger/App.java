package ledger;

import ledger.models.Balance;
import ledger.models.Command;
import ledger.services.impl.LoanServiceImpl;

import java.io.File;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws Exception {
        testAppWithInput(args[0]);
    }

    private static void testAppWithInput(String arg) throws Exception {
        LoanServiceImpl loanService = new LoanServiceImpl();
        File file = new File(arg);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] val =  input.split(" ");
            String command = val[0];
            if (command.equals(Command.LOAN.toString())) {
                loanService.takeLoan(val[1], val[2], Integer.valueOf(val[3]),
                        Integer.valueOf(val[4]), Integer.valueOf(val[5]));
            } else if (command.equals(Command.PAYMENT.toString())) {
                loanService.makePayment(val[1], val[2], Integer.valueOf(val[3]), Integer.valueOf(val[4]));
            } else if (command.equals(Command.BALANCE.toString())) {
                Balance balance = loanService.getBalance(val[1], val[2], Integer.valueOf(val[3]));
                System.out.println(val[1] + " " + val[2] + " "+ balance.getPaymentDone()
                        + " " + balance.getEmiLeft());
            } else {
                throw new Exception("Invalid Command");
            }
        }
    }
}
