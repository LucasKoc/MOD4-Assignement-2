package PayRoll;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class PayRoll {
    private String name;
    private int pay, id, hoursWorked;
    private static int idstatic = 0;

    public PayRoll(){
        setName(JOptionPane.showInputDialog("Enter name"));
        setPay(Integer.valueOf(JOptionPane.showInputDialog("Enter pay")));
        setHoursWorked(Integer.valueOf(JOptionPane.showInputDialog("Enter hours worked")));
        this.id = PayRoll.idstatic++;
    }

    public PayRoll(String name, int pay, int hoursWorked){
        setName(name);
        this.id = PayRoll.idstatic++;
        setPay(pay);
        setHoursWorked(hoursWorked);
    }

    public void setName(String name) throws StringIndexOutOfBoundsException{
        if (name == ""){
            throw new StringIndexOutOfBoundsException();
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public void setPay(int pay) throws InputMismatchException{
        if(pay<0||pay>83){
            throw new InputMismatchException();
        }
        this.pay = pay;
    }

    public int getPay(){
        return this.pay;
    }

    public void setHoursWorked(int hoursWorked) throws InputMismatchException{
        if(hoursWorked<0||hoursWorked>25){
            throw new InputMismatchException();
        }
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked(){
        return this.hoursWorked;
    }

    public int grossPay(){
        return pay * hoursWorked;
    }

}
