package tuanbtd.com.model;

public class ForgotPasswordForm {
    private String username;
    private String password;
    private int codeNumber;

    public ForgotPasswordForm(String username, String password, int codeNumber) {
        super();
        this.username = username;
        this.password = password;
        this.codeNumber = codeNumber;
    }

    public ForgotPasswordForm() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

}
