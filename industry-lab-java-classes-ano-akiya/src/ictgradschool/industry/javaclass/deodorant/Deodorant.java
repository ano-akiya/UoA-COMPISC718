package ictgradschool.industry.javaclass.deodorant;

public class Deodorant {

    private String brand;
    private String fragrance;
    private boolean rollOn;
    private double price;

    public Deodorant(String brand, String fragrance,
                     boolean rollOn, double price) {

        this.brand = brand;
        this.fragrance = fragrance;
        this.rollOn = rollOn;
        this.price = price;
    }

    public String toString() {
        String info = brand + " " + fragrance;
        if (rollOn) {
            info = info + " Roll-On";
        } else {
            info = info + " Spray";
        }
        info +=  " Deodorant, \n$" + price;
        return info;
    }

    // TODO Implement all methods below this line.

    public double getPrice()
    {
        return price;
    }

    public String getBrand()
    {

        return brand;
    }

    public boolean isRollOn()
    {
        return rollOn;
    }

    public String getFragrance()
    {
        return fragrance;
    }

    public void setPrice(double price)
    {
        this.price = price;

    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setFragrance(String fragrance) {
        this.fragrance = fragrance;
    }

    public boolean isMoreExpensiveThan(Deodorant other)
    {
        if (other.getPrice() < price)
        {
            return true;
        }
        else
        return false;
    }
}