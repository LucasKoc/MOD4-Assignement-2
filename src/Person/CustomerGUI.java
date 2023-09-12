package Person;

import javax.swing.*;
import java.awt.event.*;

public class CustomerGUI extends JFrame {
    
    public CustomerGUI(){
        createPanel();
    }

    public void createPanel(){
        setTitle("Customer List");

        setSize(200, 800);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        panel2.add(new JLabel("Customers"));
        // We ensure to create a panel for each customer in our list with their own independend value for modification by actionlistener
        for (PreferredCustomer cust : PreferredCustomer.Customers) {
            JPanel panel = new JPanel();
            JButton button2;
            JLabel spend, reduc;
            panel.add(new JLabel("ID: "+cust.getCustomerNumber()));
            panel.add(new JLabel("Name: "+cust.getName()));
            panel.add(new JLabel("Address: "+cust.getAddress()));
            panel.add(new JLabel("Phone: "+cust.getPhone()));
            panel.add(new JLabel("Mailing: "+cust.getMailingList()));
            panel.add(spend = new JLabel("Spending: "+cust.getPurchaseTotal()));
            panel.add(reduc = new JLabel("Reduction: "+cust.getReduction()));

            panel.add(button2 = new JButton("Add Money (+100)"));
            button2.addActionListener(new ActionListener(){ 
                public void actionPerformed(ActionEvent e){
                    cust.setPurchasePrice(100);
                    spend.setText("Spending: "+cust.getPurchaseTotal());
                    reduc.setText("Reduction: "+cust.getReduction());
                }
            });
            // We add our panel to the global panel
            panel2.add(panel);

        }

        add(panel2);

        setVisible(true);
    }
}
