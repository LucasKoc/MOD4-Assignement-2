package Person;

import java.util.Random;

public class PreferredCustomer extends Customer {
    Random rand = new Random();
    // Multiple array for unit test
    public static PreferredCustomer[] Customers = new PreferredCustomer[40];
    public static String[] names = {"Jean", "Marc", "Alba", "José", "Palaf", "Louis", "Paltea", "Nan", "Jhon", "Liibu", "OriginalName"};
    public static String[] streets = {"Main Street", "Elm Street", "Maple Avenue", "Oak Drive", "Cedar Lane", "Pine Road", "Birch Boulevard", "Willow Lane", "Hickory Avenue", "Sycamore Drive"};
    public static String[] streetTypes = {"Street", "Avenue", "Road", "Lane", "Drive", "Boulevard", "Place", "Circle", "Terrace", "Court"};

    private int purchase = 0;

    // Constructor, adds our customer to our static list and call createCustomer function
    public PreferredCustomer() {
        PreferredCustomer.Customers[getCustomerNumber() % PreferredCustomer.Customers.length] = this;
        Boolean mail = false;
        if (rand.nextInt(2) == 1) {
            mail = true;
        }
        createCustomer(mail);
    }

    // Generate the profile (name, address, phone, mailing, id) of our customer
    public void createCustomer(Boolean none) {
        setName(names[rand.nextInt(names.length)]);
        setAddress(rand.nextInt(30) + "th " + streetTypes[rand.nextInt(streetTypes.length)] + " " + streets[rand.nextInt(streets.length)]);
        setPhone(generatePhoneNumber());
        setMailingList(none);
        Customers[getCustomerNumber() % PreferredCustomer.Customers.length] = this;
    }

    // Generate a Canadian style phone number in String
    public static String generatePhoneNumber() {
        Random random = new Random();

        String areaCode = String.format("%03d", random.nextInt(1000));
        String exchangeCode = String.format("%03d", random.nextInt(1000));
        String subscriberNumber = String.format("%04d", random.nextInt(10000));
        String formattedPhoneNumber = String.format("(%s) %s-%s", areaCode, exchangeCode, subscriberNumber);

        return formattedPhoneNumber;
    }

    // Constructor, manual input
    public PreferredCustomer(String name, String address, String phone, boolean mailingList) {
        super(name, address, phone, mailingList);
        Customers[getCustomerNumber() % PreferredCustomer.Customers.length] = this;
    }

    // Method to calculate the reduction the client receive from their purchases
    public int getReduction() {
        int reduc = 0;

        if (purchase > 2000) {
            reduc = 10;
        } else if (purchase > 1500) {
            reduc = 7;
        } else if (purchase > 1000) {
            reduc = 6;
        } else if (purchase > 500) {
            reduc = 5;
        }

        return reduc;
    }

    public int getPurchaseTotal() {
        return this.purchase;
    }

    public void setPurchasePrice(int cost) {
        purchase = purchase + cost;
    }

    public int getPurchasePrice(int cost) {
        int price;
        price = cost - cost * getReduction() / 100;
        setPurchasePrice(cost);
        return price;
    }

    @Override
    public String toString() {
        String value = "--------------";
        value += "\n\tID: " + customerNumber + "\n--------------";
        value += "\n\tName: " + name + "\n\tPhone: " + phone + "\n\tAddress: " + address + "\n";
        if (mailingList) {
            value += "\tMailing: true";
        }
        value += "\n\tPurchase: " + getPurchaseTotal();
        if (getReduction() > 0) {
            value += "\n\tReduction: " + getReduction();
        }
        return value;
    }

    // STATIC: print our entire customer list
    public static void showCustomer() {
        for (PreferredCustomer customer : Customers) {
            if (customer != null)
                System.out.println(customer);
        }
    }

    // STATIC: generate spending to our customer list, mostly for showcase and debug
    public static void randomCustomerSpending() {
        Random rand = new Random();
        for (int i = 0; i < PreferredCustomer.Customers.length + rand.nextInt(30); i++) {
            PreferredCustomer cust = PreferredCustomer.Customers[rand.nextInt(Customer.customerNumberStatic)];
            if (cust != null) {
                int value = rand.nextInt(1000);
                cust.getPurchasePrice(value);
                System.out.println(cust.getName() + " bought $" + value + " worth of product, is reduction in price is now at: " + cust.getReduction());
            }
        }
    }
}
