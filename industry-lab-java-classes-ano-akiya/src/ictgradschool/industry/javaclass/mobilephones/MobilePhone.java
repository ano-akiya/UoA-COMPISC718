package ictgradschool.industry.javaclass.mobilephones;

public class MobilePhone {

    // TODO Declare the 3 instance variables:
    // brand
    // model
    // price

    String brand;
    String model;
    double price;
    
    public MobilePhone(String brand, String model, double price) {
        // Complete this constructor method
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // TODO Uncomment these methods once the corresponding instance variable has been declared.
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    // TODO Insert getModel() method here
    public String getModel()
    {
        return model;
    }

    // TODO Insert setModel() method here
    public void setModel(String model)
    {
        this.model = model;
    }
    // TODO Insert getPrice() method here

    public double getPrice()
    {
        return price;
    }
    // TODO Insert setPrice() method here
    public void setPrice(double price)
    {
        this.price = price;

    }
    // TODO Insert toString() method here
    public String toString()
    {
        String output = "";
        output = brand + " " + model + " which cost $" + price;
        return output;
    }
    // TODO Insert isCheaperThan() method here
    public boolean isCheaperThan(MobilePhone other)
    {
        if (price < other.price)
        {
            return true;
        }
        else
            return false;
    }
    // TODO Insert equals() method here
    public boolean equals(MobilePhone other)
    {
        if (this.getModel().equals(other.getModel()))
        {
            return true;
        }
        else
            return false;
    }

}


