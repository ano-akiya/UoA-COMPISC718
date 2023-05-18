package ictgradschool.industry.morepractice.payrollapplication;

public abstract class Employee {
    private static int count = 0;
    protected int employeeId;
    protected String name, type;

    //TODO: 1.i. Create the constructor with two string arguments 'name' & 'type'
    public Employee(String name, String type)
    {
        this.name = name;
        this.type = type;
        count = count + 1;
        this.employeeId = count;
    }

    //TODO: 1.ii. Create the getter methods for name, type and id
    public void getter()
    {
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    //TODO: 1.iii. Create an abstract 'salary' method which will return a double
    public abstract double salary();


    //TODO: 1.iv. Implement the toString method which will return employee's name, id and the type.
    public String toString()
    {
        String output = name + "(ID: " + employeeId + ") is a " + type;
        return output;

    }

    //TODO: 7.i. Create earnsMoreThan method to compare the salary of two employees
    public boolean earnsMoreThan(double a_salary, double b_salary)
    {
        if (a_salary > b_salary)
        {
            return true;
        }
        else
            return false;
    }

}
