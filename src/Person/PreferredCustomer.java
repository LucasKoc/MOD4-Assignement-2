package Person;

import java.util.Random;

public class PreferredCustomer extends Customer {
    Random rand = new Random();
    public static PreferredCustomer[] Customers = new PreferredCustomer[40];
    public static String[] names = {"Jean", "Marc", "Alba", "José", "Palaf", "Louis", "Paltea", "Nan", "Jhon", "Liibu", "OriginalName"};
    private int purchase = 0;

    public PreferredCustomer(){
        PreferredCustomer.Customers[getCustomerNumber()%PreferredCustomer.Customers.length] = this;
        createCustomer(true);
    }

    public void createCustomer(Boolean none){
        setName(names[rand.nextInt(names.length)]);
        setAddress("address");
        setPhone(String.valueOf(rand.nextInt(70000000)+1000000));
        setMailingList(none);
        Customers[getCustomerNumber()%PreferredCustomer.Customers.length] = this;
    }

    public PreferredCustomer(String name, String address, String phone, boolean mailingList){
        super(name, address, phone, mailingList);
        Customers[getCustomerNumber()%PreferredCustomer.Customers.length] = this;
    }

    public int getReduction(){
        int reduc = 0;

        if (purchase>2000){
            reduc = 5;
        }else if(purchase>1500){
            reduc = 6;
        }else if(purchase>1000){
            reduc = 7;
        }else if(purchase>500){
            reduc = 10;
        }

        return reduc;
    }

    public int getPurchaseTotal(){
        return this.purchase;
    }

    public void setPurchasePrice(int cost){
        purchase = purchase + cost;
    }

    public int getPurchasePrice(int cost){
        int price;
        price = cost - cost * getReduction()/100;
        setPurchasePrice(cost);
        return price;
    }

    @Override
    public String toString(){
        String value = "--------------";
        value += "\n\tID: "+customerNumber+"\n--------------";
        value += "\n\tName: "+name+"\n\tPhone: "+phone+"\n\tAddress: "+address+"\n";
        if(mailingList){
            value += "\tMailing: true";
        }
        value += "\n\tPurchase: "+getPurchaseTotal();
        if (getReduction()>0){
            value += "\n\tReduction: "+getReduction();
        }
        return value;
    }

    public static void showCustomer(){
        for (PreferredCustomer customer : Customers) {
            if(customer!=null)
                System.out.println(customer);
        }
    }

    public static void randomCustomerSpending(){
        Random rand = new Random();
        for (int i = 0; i < PreferredCustomer.Customers.length + rand.nextInt(30); i++) {
            PreferredCustomer cust = PreferredCustomer.Customers[rand.nextInt(Customer.customerNumberStatic)];
            if(cust!=null){
                int value = rand.nextInt(6000);
                cust.getPurchasePrice(value);
                System.out.println(cust.getName()+" bought $"+value+" worth of product, is reduction in price is now at: "+cust.getReduction());
            }
        }
    }
}
