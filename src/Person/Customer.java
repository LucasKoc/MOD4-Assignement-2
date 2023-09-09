package Person;

public class Customer extends Person {
    protected boolean mailingList;
    protected int customerNumber;
    // To ensure every client has a unique customer number
    protected static int customerNumberStatic = 0;

    public Customer(){
        this.customerNumber = customerNumberStatic++;
    }

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

