package Person;

public class Customer extends Person {
    private boolean mailingList;
    private int customerNumber;
    private static int customerNumberStatic = 0;

    public Customer(){}

    public Customer(String name, String address, String phone, boolean mailingList){
        super(name, address, phone);
        this.mailingList = mailingList;
        this.customerNumber = customerNumberStatic++;
    }

    public int getCustomerNumber(){
        return this.customerNumber;
    }

    public void setMailingList(boolean mailingList){
        this.mailingList = mailingList;
    }

    public boolean getMailingList(){
        return this.mailingList;
    }
}

