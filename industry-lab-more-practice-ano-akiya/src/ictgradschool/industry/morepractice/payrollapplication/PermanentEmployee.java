package ictgradschool.industry.morepractice.payrollapplication;

public class PermanentEmployee extends Employee {

    //pay a fixed based salary, plus bonus

    private double baseSalary;

    public PermanentEmployee(String name, double baseSalary){
        super(name, "permanent");
        this.baseSalary = baseSalary;
    }

    @Override
    public double salary()
    {
        return baseSalary;
    }

    /*TODO: 5.i. Create payBonus method, which takes a fixed amount of bonus as an input
            and apply it to the baseSalary. This method then return the bonus amount as a double
     */
    public double payBonus(double fix_double)
    {
        double bonus;
        bonus = fix_double;
        this.baseSalary = baseSalary + bonus;

        return bonus;
    }

}
