/**
 * Main class of the package Password Verifier
 * The password should be at least six characters long.
 * The password should contain at least one uppercase and at least one lowercase letter.
 * The password should have at least one digit.
 *
 * @author SOLAN Tao & KOCOGLU Lucas
 * @version N/A
 * @since 2023-09-06
 */
package PasswordVerifier;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner instance to scan input
        Scanner myScan = new Scanner(System.in);

        // Password instance for verification and password storage
        PasswordVerifier pwd = new PasswordVerifier();

        // Indications to the user
        System.out.println("------------Example.com password--------------" +
                "\nPlease enter a strong password." +
                "\nStrong password is defined by :" +
                "\n\t> Six characters long at least" +
                "\n\t> Contain at least one uppercase letter" +
                "\n\t> Contain at least one lowercase letter" +
                "\n\t> Contain at least on digit.");

        // do while with cond : password does not meet Criteria
        do {
            System.out.print("---------------------------------------------" +
                    "\nYour password : ");
            pwd.setPwd(myScan.nextLine());
        } while(!pwd.verifyCriteria());

        System.out.println("---------------------------------------------" +
                "\nYour password has been set successfully !");
    }
}