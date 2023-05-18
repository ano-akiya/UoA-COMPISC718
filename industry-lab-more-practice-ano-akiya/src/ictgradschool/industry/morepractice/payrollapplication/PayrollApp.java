package ictgradschool.industry.morepractice.payrollapplication;

public class PayrollApp {
    private double permanent_bonus = 100.0;
    private double sale_bonusRate = 0.02;

    public static void main(String[] args) {
        PayrollApp p = new PayrollApp();
        p.start();
    }

    private void start() {
        /*TODO: 4.i. Create an Employee array with the variable name 'employees'.
                Call createEmployee() method to initialise an Employee array.
         */

        Employee[] employees = createEmployee();

        System.out.println("=====================================================");
        System.out.println("Auckland Pizza Store has the following employees");
        System.out.println();
        //TODO: 4.ii. Implement the printEmployeeDetails method
        printEmployeeDetails(employees);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println("Payroll office is paying the salary.");
        System.out.println();
        //TODO: 4.iii. Implement the paySalary method
        paySalary(employees);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println("We have a great year. Let's share the fun!");
        System.out.println("Bonus will be paid to permanent and sales employees.");
        System.out.println();
        //TODO: 5.iii. Implement the payBonus method
        payBonus(employees);
        System.out.println();

        System.out.println("=====================================================");
        System.out.println("The final salary balances:");
        System.out.println();
        //TODO: 6. Implement the printBalance method
        printBalance(employees);
        System.out.println();

        System.out.println("=====================================================");
        //TODO: 7.ii. Implement the getMostRichestEmployee method
        System.out.print("The richest employee in the company is: " + getMostRichestEmployee(employees).getName());
        System.out.println();
        System.out.println();

    }

    private Employee[] createEmployee() {
        Employee[] employees = new Employee[20];
        employees[0] = new PermanentEmployee("Andrew", 120050);
        employees[1] = new SeasonalEmployee("Brian", 688, 22.56);
        employees[2] = new SalesEmployee("Cathy", 600000, 0.20);
        employees[3] = new PermanentEmployee("David", 100500);
        employees[4] = new PermanentEmployee("Emma", 60050);
        employees[5] = new SalesEmployee("Franky", 200000, 0.18);
        employees[6] = new SalesEmployee("Gill", 1005000, 0.22);
        employees[7] = new SeasonalEmployee("Helen", 833, 21.55);
        employees[8] = new SalesEmployee("Ian", 500000, 0.18);
        employees[9] = new SeasonalEmployee("James", 800, 25);
        employees[10] = new SeasonalEmployee("Kevin", 100, 50.0);
        employees[11] = new PermanentEmployee("Lynda", 54321);
        employees[12] = new SeasonalEmployee("Michael", 556, 22.22);
        employees[13] = new SeasonalEmployee("Nancy", 2000, 23);
        employees[14] = new PermanentEmployee("Olivia", 77000);
        employees[15] = new PermanentEmployee("Peter", 63900);
        employees[16] = new SeasonalEmployee("Queen", 713, 23.33);
        employees[17] = new SeasonalEmployee("Richard", 1500, 21.34);
        employees[18] = new PermanentEmployee("Steve", 90000);
        employees[19] = new PermanentEmployee("Tyne", 100500);

        return employees;
    }

    private void printEmployeeDetails(Employee[] employees)
    {
        for (int i = 0; i < employees.length; i++)
        {
            employees[i].toString();
        }
    }

    private void paySalary(Employee[] employees)
    {
        for (int i = 0; i < employees.length; i++)
        {
            System.out.println(employees[i].name + " receives "+ employees[i].salary());
        }
    }

    private void payBonus(Employee[] employees)
    {
        for (int i = 0; i < employees.length; i ++)
        {
            if (employees[i].type.equals("sales")
                    || employees[i].type.equals("permanent"))
            {
                employees[i].toString();
                if (employees[i] instanceof SalesEmployee)
                {
                    double temp_bonus = ((SalesEmployee) employees[i]).payBonus(sale_bonusRate);
                    System.out.println("$" + temp_bonus + " bonus is paid");
                }
                else if (employees[i] instanceof PermanentEmployee)
                {
                    double temp_bonus = ((PermanentEmployee) employees[i]).payBonus(permanent_bonus);
                    System.out.println("$" + temp_bonus + " bonus is paid");
                }
            }
        }
    }

    private void printBalance(Employee[] employees)
    {
        for (int i = 0; i < employees.length; i ++)
        {
            System.out.println("The balance of " + employees[i].name + " is $" + employees[i].salary());
        }
    }

    private Employee getMostRichestEmployee(Employee[] employees)
    {
        Employee temp;
        for (int i = 0; i < employees.length; i ++)
        {
            for (int j = i + 1; j < employees.length; j ++)
            {
                if (! employees[i].earnsMoreThan(employees[i].salary(), employees[j].salary()))
                {
                    temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        return employees[0];
    }




}
