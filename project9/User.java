import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable {
    protected String userName;
    protected String PIN;

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("User name:");
        String u = sc.nextLine().trim();
        System.out.print("PIN:");
        String p = sc.nextLine().trim();
        return login(u, p);
    }

    public boolean login(String userName, String PIN) {
        boolean ok = this.userName != null
                && this.userName.equals(userName)
                && this.PIN != null
                && this.PIN.equals(PIN);
        if (ok) System.out.println("Login Successful");
        else System.out.println("Login Failed");
        return ok;
    }

    public void setUserName(String userName) { this.userName = userName; }
    public String getUserName() { return userName; }

    public void setPIN(String PIN) { this.PIN = PIN; }
    public String getPIN() { return PIN; }

    public abstract String getReport();
}