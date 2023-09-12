/**
 * PasswordVerifier Class
 * The class store the password and verify if its meeting all criteria :
 *  The password should be at least six characters long.
 *  The password should contain at least one uppercase and at least one lowercase letter.
 *  The password should have at least one digit.
 * It has getter and setter for pwd
 * It has functions to verify the String for each criteria
 * If criteria is not meet, it display to the user which criteria is missing.
 *
 * @author SOLAN Tao & KOCOGLU Lucas
 * @version N/A
 * @since 2023-09-06
 */

package PasswordVerifier;

public class PasswordVerifier {
    private String pwd;

    /**
     * Constructor of PasswordVerifier with 0 parameters
     * pwd is initialized (by default) to "".
     */
    public PasswordVerifier() {
        this.pwd = "";
    }

    /**
     * Constructor of PasswordVerifier with 1 parameters
     * pwd is initialized by the given parameters
     * @param str password of the instance
     */
    public PasswordVerifier(String str) {
        this.pwd = str;
    }


    /**
     * Getter of the private variable ftemp
     * @return (String) the password of the instance
     */
    public String getPwd() {
        return this.pwd;
    }

    /**
     * Setter of the private variable pwd
     * Set the password of the instance
     * @param pwd password of the instance
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Function isSixLong
     * Verify the following criteria :
     * > The password should be at least six characters long.
     * @param pwd password of the instance
     * @return (boolean) if pwd length is superior or equals six
     */
    public boolean isSixLong(String pwd) {
        return pwd.length() >= 6;
    }

    /**
     * Function isLowerCase
     * Verify the following criteria :
     * > The password should contain at least one lowercase letter.
     * @param pwd password of the instance
     * @return (boolean) if pwd has at least one lowercase letter
     */
    public boolean isLowerCase(String pwd) {
        for(int i = 0; i < pwd.length() ; i++) {
            if (Character.isLowerCase(pwd.charAt(i))) return true;
        }
        return false;
    }

    /**
     * Function isUpperCase
     * Verify the following criteria :
     * > The password should contain at least one uppercase letter.
     * @param pwd password of the instance
     * @return (boolean) if pwd has at least one uppercase letter
     */
    public boolean isUpperCase(String pwd) {
        for(int i = 0; i < pwd.length() ; i++) {
            if (Character.isUpperCase(pwd.charAt(i))) return true;
        }
        return false;
    }

    /**
     * Function isDigit
     * Verify the following criteria :
     * > The password should have at least one digit.
     * @param pwd password of the instance
     * @return (boolean) if pwd has at least one digit
     */
    public boolean isDigit(String pwd) {
        for(int i = 0; i < pwd.length() ; i++) {
            if (Character.isDigit(pwd.charAt(i))) return true;
        }
        return false;
    }

    /**
     * Function verifyCriteria
     * Set booleans for each criteria (isSixLong, isLowerCase, …) with value return of its associated function.
     * If a criteria has not been meet, display to the user the following criteria.
     * @return (boolean) if all criteria has been meet
     */
    public boolean verifyCriteria() {
        // Boolean for each criteria
        boolean isSixLong = isSixLong(this.pwd), isLowerCase = this.isLowerCase(this.pwd), isUpperCase = this.isUpperCase(this.pwd), isDigit = this.isDigit(this.pwd);

        // If one of the criteria has not been meet, notify it to the user
        if (!(isSixLong && isLowerCase && isUpperCase && isDigit)) {
            System.out.println("---------------------------------------------" +
                    "\n/!\\ YOUR PASSWORD IS NOT ENOUGH STRONG /!\\" +
                    "\nYou need to add : ");
            if (!isDigit)
                System.out.println("\t > A digit");
            if (!isLowerCase)
                System.out.println("\t > A lowercase letter");
            if (!isUpperCase)
                System.out.println("\t > An uppercase letter");
            if (!isSixLong)
                System.out.println("\t > More characters (need to be 6 characters long at least)");
        }
        return isSixLong && isLowerCase && isUpperCase && isDigit;
    }
}
