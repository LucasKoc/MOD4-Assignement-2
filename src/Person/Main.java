package Person;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int clientNumber = 0;
        do {
            try {
                clientNumber = Integer.valueOf(JOptionPane.showInputDialog("Give number of client"));
                PreferredCustomer.Customers = new PreferredCustomer[clientNumber];
            } catch (Exception e) {
                System.out.println("Please enter a valid value !");
            }
        } while(clientNumber <= 0);
            
        for (int i = 0; i < PreferredCustomer.Customers.length; i++) {
            new PreferredCustomer();
        }
        //PreferredCustomer.showCustomer();
        PreferredCustomer.randomCustomerSpending();
        //PreferredCustomer.showCustomer();
        new CustomerGUI();

    }
}
