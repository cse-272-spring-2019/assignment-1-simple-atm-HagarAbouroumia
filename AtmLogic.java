package myatm;

public class AtmLogic implements Interface {

    private final String passcode;
    private String balance;
    AtmLogic authentication;
       int index;

    public AtmLogic() {
        passcode = "1";
        balance = "0";
        index = 4;
    }

    public void setAuthentication(AtmLogic authentication) {
        this.authentication = authentication;
    }

    public String getCurrentBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public boolean validate(String password) {
        return (passcode.equals(password));
    }

    public boolean check(String Amount) {
        double x = Double.valueOf(Amount);
        double y = Double.valueOf(balance);
        return (x < y);
    }

    public void withdraw(String Amount) {
        double x = Double.valueOf(Amount);
        double y = Double.valueOf(balance);
        y = y - x;
        String string = String.valueOf(y);
        setBalance(string);
    }

    @Override
    public void deposit(String amount) {
        double x = Double.valueOf(amount);
        double y = Double.valueOf(balance);
        y = y + x;
        String z = String.valueOf(y);
        setBalance(z);
    }

   

}
