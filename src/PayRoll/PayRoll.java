package PayRoll;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class PayRoll {
    private String name;
    private int pay, id, hoursWorked;
    private static int idstatic = 0;


    //Constructor requiring input from the clients
    public PayRoll() {
        boolean valid;

        //Multiple Loop to ensure safe input by the user by catching Exception
        do {
            valid = false;
            try {
                setName(JOptionPane.showInputDialog("Enter name"));
                valid = true;
            } catch (StringIndexOutOfBoundsException i) {
                System.out.println("Please enter a name");
            } catch (NullPointerException i) {
                System.out.println("Exiting");
                return;
            }
        } while (!valid);

        do {
            valid = false;
            try {
                setPay(Integer.valueOf(JOptionPane.showInputDialog("Enter pay")));
                valid = true;
            } catch (InputMismatchException i) {
                System.out.println("Please input a value between 0 and 84");
            } catch (NumberFormatException i) {
                System.out.println("Please input a number");
            }
        } while (!valid);

        do {
            valid = false;
            try {
                setHoursWorked(Integer.valueOf(JOptionPane.showInputDialog("Enter hours worked")));
                valid = true;
            } catch (InputMismatchException i) {
                System.out.println("Please input a value between 0 and 24");
            } catch (NumberFormatException i) {
                System.out.println("Please input a number");
            }
        } while (!valid);


        this.id = PayRoll.idstatic++;
    }


    //System constructor
    public PayRoll(String name, int pay, int hoursWorked) {
        setName(name);
        this.id = PayRoll.idstatic++;
        setPay(pay);
        setHoursWorked(hoursWorked);
    }

    // Setter for name variable
    public void setName(String name) throws StringIndexOutOfBoundsException {
        if (name.isEmpty()) {
            throw new StringIndexOutOfBoundsException();
        }
        this.name = name;
    }

    // Getter for name variable
    public String getName() {
        return this.name;
    }

    // Getter for ID variable
    public int getId() {
        return this.id;
    }

    // Setter for pay variable
    public void setPay(int pay) throws InputMismatchException {
        if (pay < 0 || pay > 83) {
            throw new InputMismatchException();
        }
        this.pay = pay;
    }

    // Getter for pay variable
    public int getPay() {
        return this.pay;
    }

    // Setter for hours worked
    public void setHoursWorked(int hoursWorked) throws InputMismatchException {
        if (hoursWorked < 0 || hoursWorked > 25) {
            throw new InputMismatchException();
        }
        this.hoursWorked = hoursWorked;
    }

    // Getter for hours worked
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    // Method returning the grosspay from local value
    public int grossPay() {
        return pay * hoursWorked;
    }

}
