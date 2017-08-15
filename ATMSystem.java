/**@ATMSystem main class to run ATM machine
 * Created by yehiaqtaish on 6/18/16.
 */
import java.util.Scanner;
public class ATMSystem {

    /**
     * main class to call methods from Bank, Account
     * @param args which is for commandline
     * @postcondition working ATM program
     */
    public static void main(String[] args) {

        Bank bank = new Bank();
        Account a1 = new Account("Yehia", 40, 22, "2017-08-16", "1422");
        Account a2 = new Account("Moe", 40, 11, "2011-08-16", "1322");
        Account b1 = new Account("Yehia", 40, 23, "2017-08-16", "5522");
        Account b2 = new Account("Johnny", 40, 21, "2020-08-16", "1412");
        Account b3 = new Account("Yehia", 40, 31, "2014-08-16", "1722");
        bank.addBankA(a1);
        bank.addBankA(a2);
        bank.addBankB(b1);
        bank.addBankB(b2);
        bank.addBankB(b3);
        bank.showAccounts();
        System.out.println("Welcome to ATM System: Please enter ATM choice");
        Scanner sc = new Scanner(System.in);
        String atmChoice;
        atmChoice = sc.nextLine();
        char atmC = atmChoice.charAt(4);
        if (atmC == 'A') {
            boolean valid;
            do {
                System.out.println("Please enter card Number");
                int card = sc.nextInt();
                valid = bank.authorizeATMA(card);
                if (!valid) {
                    System.out.println("try again");
                }
            } while (!valid);
            String password;
            boolean pValid = false;
            double amount;
            do {
                System.out.println("Enter password");
                password = sc.next();
                if (bank.authorizeCardA(password) == true) {
                    pValid = true;
                    break;
                } else {
                    System.out.println("Wrong password, try again");
                }
            } while (!pValid);
            boolean valid2 = true;
            while (valid2) {
                System.out.println("enter amount to withdrawal or enter [2] to quit.");
                amount = sc.nextDouble();
                if (amount == 2) {
                    valid2 = false;
                    break;
                }
                if (amount >= 100) {
                    System.out.println("This amount exceeds the maximum amount you can withdraw per transaction");
                }
                if (amount > 40) {
                    System.out.println("The amount exceeds the current balance");
                }

                double balances = bank.withdraw(password, amount);



            }
        }

        if (atmC == 'B') {
            boolean valid;
            do {
                System.out.println("Please enter card Number");
                int card = sc.nextInt();
                valid = bank.authorizeATMB(card);
                if (!valid) {
                    System.out.println("try again");
                }
            } while (!valid);
            String password;
            boolean pValid = false;
            double amount;
            do {
                System.out.println("Enter password");
                password = sc.next();
                if (bank.authorizeCardB(password) == true) {
                    pValid = true;
                    break;
                } else {
                    System.out.println("try again");
                }
            } while (!pValid);
            boolean valid2 = true;
            while (valid2) {
                System.out.println("Please enter amount to withdrawal!");
                amount = sc.nextDouble();
                if (amount == 2) {
                    valid2 = false;
                    break;
                }
                if (amount >= 100) {
                    System.out.println("This amount exceeds the maximum amount you can withdraw per transaction");
                }
                if (amount > 40 && amount < 100) {
                    System.out.println("The amount exceeds the current balance");
                }
                double balances = bank.withdrawB(password, amount);


            }
        }
    }
}


