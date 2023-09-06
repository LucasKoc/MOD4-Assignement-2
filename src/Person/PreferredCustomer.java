package Person;

public class PreferredCustomer extends Customer {
    private int purchase = 0;

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

    public int getPurchasePrice(int cost){
        int price;
        price = cost - cost * getReduction()/100;
        purchase = purchase + cost;
        return price;
    }
}
