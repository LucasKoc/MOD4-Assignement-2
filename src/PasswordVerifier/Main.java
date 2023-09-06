/**
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
        Scanner myScan = new Scanner(System.in);
        PasswordVerifier pwd = new PasswordVerifier();
        do {
            System.out.println("--------------------------" +
                    "\nPlease enter a strong password." +
                    "\nStrong password is defined by :" +
                    "\n\t> Six characters long a least" +
                    "\n\t> Contain at least one uppercase letter" +
                    "\n\t> Contain at least one lowercase letter" +
                    "\n\t> Contain at least on digit." +
                    "\n--------------------------" +
                    "\nYour password :");
            pwd.setStr(myScan.nextLine());
        } while(!pwd.verifyCriteria());
    }
}