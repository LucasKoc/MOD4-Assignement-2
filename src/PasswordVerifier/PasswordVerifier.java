package PasswordVerifier;

public class PasswordVerifier {
    private String pwd;

    public PasswordVerifier() {
        this.pwd = "";
    }

    public PasswordVerifier(String str) {
        this.pwd = str;
    }

    public String getStr() {
        return this.pwd;
    }

    public void setStr(String str) {
        this.pwd = str;
    }

    public boolean isSixLong(String pwd) {
        return pwd.length() >= 6;
    }

    public boolean isLowerCase(String pwd) {
        for(int i = 0; i < pwd.length() ; i++) {
            if (Character.isLowerCase(pwd.charAt(i))) return true;
        }
        return false;
    }

    public boolean isUpperCase(String pwd) {
        for(int i = 0; i < pwd.length() ; i++) {
            if (Character.isUpperCase(pwd.charAt(i))) return true;
        }
        return false;
    }

    public boolean isDigit(String pwd) {
        for(int i = 0; i < pwd.length() ; i++) {
            if (Character.isDigit(pwd.charAt(i))) return true;
        }
        return false;
    }

    public boolean verifyCriteria() {
        boolean isSixLong = isSixLong(this.pwd), isLowerCase = this.isLowerCase(this.pwd), isUpperCase = this.isUpperCase(this.pwd), isDigit = this.isDigit(this.pwd);
        System.out.println(isSixLong + " " + isLowerCase + " " + isUpperCase + " " + isDigit);
        return isSixLong && isLowerCase && isUpperCase && isDigit;
    }

    @Override
    public String toString() {
        return "PasswordVerifier{" +
                "str='" + this.pwd + '\'' +
                '}';
    }
}
