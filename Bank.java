import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

/**@Bank class that has two arraylists for Bank A,B.
 * Created by yehiaqtaish on 6/17/16.
 */
public class Bank{

    /**
     * @ArrayList that stores for two banks A,B
     */
    private ArrayList<Account> A;
    private ArrayList<Account> B;

    /**
     * @Constructor to initiate the ArrayList for banks
     */
    public Bank(){
        A = new ArrayList<>();
        B = new ArrayList<>();
    }

    /**
     * @param acc account to be added
     * @postcondition adds account to bank A list
     */
    public void addBankA(Account acc){

        A.add(acc);

    }
    /**
     * @param acc account to be added
     * @postcondition adds account to bank B list
     */
    public void addBankB(Account acc){

        B.add(acc);
    }

    /**
     * @return list of accounts for bank A, B ArrayList
     */
    public void showAccounts(){

        for(Account acc : A) System.out.println(acc.toString());
        for(Account acc : B) System.out.println(acc.toString());

    }

    /**
     * @param card card number for bank A
     * @precondition 2 digit number
     * @postcondition checkx if ATM is authorized with card
     */
    public boolean authorizeATMA(int card){
        boolean isTrue = false;
        boolean isIt = false;
        for(Account acc : A){
            if (card == acc.getCardNum()) {
                isTrue = true;
                    if (card == acc.getCardNum() && cardExp(acc.getExpDate())){
                        System.out.println("card is authorized");
                    isIt = true;
                        break;
            }if(isIt == false) {
                    System.out.println("card is expired");
                }
            }
        }

        if(isTrue == false){
            System.out.println("card is not supported by ATM");
        }
        System.out.println(isTrue && isIt);
        return (isTrue && isIt);
    }

    /**
     * @param card card number for bank B
     * @precondition 2 digit number
     * @postcondition checks if ATM is authorized with card
     */
    public boolean authorizeATMB(int card){
        boolean isTrue = false;
        boolean isIt = false;
        for(Account acc : B){
            if (card == acc.getCardNum()) {
                isTrue = true;
                if (card == acc.getCardNum() && cardExp(acc.getExpDate())){
                    System.out.println("card is authorized");
                    isIt = true;
                    break;
                }if(isIt == false) {
                    System.out.println("card is expired");
                }
            }
        }

        if(isTrue == false){
            System.out.println("card is not supported by ATM");
        }
        System.out.println(isTrue && isIt);
        return (isTrue && isIt);
    }

    /**
     * @param month to check if card is expired
     * @return true if not expired, false if expired
     */
    public static boolean cardExp(String month){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        if(month.compareTo(today) > 0){
            return true;
        }else
            return false;
    }
    /**
     * @param passCode: Account password
     * @precondition: passCode is 4 digit number
     * @postcondition: customer could access card for withdrawal
     */
    public boolean authorizeCardA(String passCode){
        boolean isTrue = false;
        for(Account acc : A){
            if (passCode.compareTo(acc.getPassword())>0) {
                isTrue = true;
                break;
            }
        }
        return isTrue;

    }

    /**
     * @param passCode: Account password
     * @precondition: passCode has to be an integer
     * @postcondition: customer could access card
     */
    public boolean authorizeCardB(String passCode){
        boolean isTrue = false;
        for(Account acc : B){
                if (passCode.compareTo(acc.getPassword())>0) {
                    isTrue = true;
                    break;
                }else{
                    System.out.println("Wrong password");
                }
        }
        return isTrue;
    }


    /**
     * @param amount: the amount of money to withdraw
     * @precondition amount: amount > 0, amount < 20$
     * @postcondition: balance will be decreased
     */
    public double withdraw(String passCode,double amount){
        double amount2= 0;
        for(Account acc : A){
            if (passCode.compareTo(acc.getPassword()) > 0) {
                if(amount <= acc.getBalance()) {
                    System.out.println(acc.getBalance());
                    amount2 = acc.getBalance() - amount;
                    acc.setBalance(amount2);
                    System.out.print("Your remaining balance is:  ");
                    System.out.println(acc.getBalance());
                    return amount2;
                }

            }
        }
        return amount2;
    }

    /**
     * @param amount: the amount of money to withdraw for bank B
     * @precondition amount: amount > 0
     * @postcondition: balance will be decreased
     */
    public double withdrawB(String passCode,double amount){
        double amount2= 0;
        for(Account acc : B){
            if (passCode.compareTo(acc.getPassword()) > 0) {
                if(amount <= acc.getBalance()) {
                    System.out.println(acc.getBalance());
                    amount2 = acc.getBalance() - amount;
                    acc.setBalance(amount2);
                    System.out.print("Your remaining balance is:  ");
                    System.out.println(acc.getBalance());
                    return amount2;
                }

            }
        }
        return amount2;
    }



}
