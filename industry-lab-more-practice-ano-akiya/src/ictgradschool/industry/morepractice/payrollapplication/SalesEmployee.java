package ictgradschool.industry.morepractice.payrollapplication;

public class SalesEmployee extends Employee
{
    double sales;
    double commission;
    public SalesEmployee(String name,double sales, double commission)
    {
        super(name,"sales");
        this.sales = sales;
        this.commission = commission;
    }

    public double salary()
    {
        double salary = sales * commission;
        return salary;
    }

    public double payBonus(double bonusRate)
    {
        double bonus;
        double bonusSale;

        bonusSale = bonusRate * sales;
        bonus = bonusSale * commission;

        this.sales = sales + bonusSale;

        return bonus;
    }
}
