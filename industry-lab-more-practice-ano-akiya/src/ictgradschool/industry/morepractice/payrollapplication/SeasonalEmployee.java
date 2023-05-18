package ictgradschool.industry.morepractice.payrollapplication;

public class SeasonalEmployee extends Employee {
    double hours;
    double wageRate;
    public SeasonalEmployee(String name,double hours, double wageRate)
    {
        super(name,"seasonal");
        this.hours = hours;
        this.wageRate = wageRate;
    }

    public double salary()
    {
        double salary = hours * wageRate;
        return salary;
    }
}
