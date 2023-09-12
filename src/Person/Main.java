package Person;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int clientNumber = Integer.valueOf(JOptionPane.showInputDialog("Give number of client"));
        PreferredCustomer.Customers = new PreferredCustomer[clientNumber];
        for (int i = 0; i < PreferredCustomer.Customers.length; i++) {
            new PreferredCustomer();
        }
        //PreferredCustomer.showCustomer();
        PreferredCustomer.randomCustomerSpending();
        //PreferredCustomer.showCustomer();
        new CustomerGUI();
        
    }
}
