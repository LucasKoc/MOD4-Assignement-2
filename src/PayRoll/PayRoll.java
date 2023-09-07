package PayRoll;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class PayRoll {
    private String name;
    private int pay, id, hoursWorked;
    private static int idstatic = 0;

    public PayRoll(){
        boolean valid;

        do {
            valid = false;
            try{
                setName(JOptionPane.showInputDialog("Enter name"));
                valid = true;
            }catch(StringIndexOutOfBoundsException i){
                System.out.println("Please enter a name");
            }catch(NullPointerException i){
                System.out.println("Exiting");
                return;
            }
        } while (!valid);

        do {
            valid = false;
            try{
                setPay(Integer.valueOf(JOptionPane.showInputDialog("Enter pay")));
                valid = true;
            }catch(InputMismatchException i){
                System.out.println("Please input a value between 0 and 84");
            }catch(NumberFormatException i){
                System.out.println("Please input a number");
            }
        } while (!valid);

        do {
            valid = false;
            try{
                setHoursWorked(Integer.valueOf(JOptionPane.showInputDialog("Enter hours worked")));
                valid = true;
            }catch(InputMismatchException i){
                System.out.println("Please input a value between 0 and 24");
            }catch(NumberFormatException i){
                System.out.println("Plesae input a number");
            }
        } while (!valid);
        
        
        
        this.id = PayRoll.idstatic++;
    }

    public PayRoll(String name, int pay, int hoursWorked){
        setName(name);
        this.id = PayRoll.idstatic++;
        setPay(pay);
        setHoursWorked(hoursWorked);
    }

    public void setName(String name) throws StringIndexOutOfBoundsException{
        if (name.isEmpty()){
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
