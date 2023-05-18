package ictgradschool.industry.designpatterns.companydb.view;

import ictgradschool.industry.designpatterns.companydb.model.Employee;
import ictgradschool.industry.designpatterns.companydb.model.Manager;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Optional;

public class EmployeeTableAdapter extends AbstractTableModel {

    public List<Employee> employeeList;
    public EmployeeTableAdapter(Manager boss) {
        // TODO complete this
        this.employeeList = boss.getAllEmployees();
    }

    @Override
    public int getRowCount() {
        // TODO complete this
        int numOfEmployee = employeeList.size();
        return numOfEmployee;
    }

    @Override
    public int getColumnCount() {
        // TODO complete this
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO complete this
        Employee item = employeeList.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return item.getId();
            case 1:
                return item.getName();
            case 2:
                return item.getEmail();
            case 3:
                return item.getJobTitle();
            case 4:
                if (item.getManager() == null)
                {
                    return "N/A";
                }
                else {
                    return item.getManager().getName();
                }
            case 5:
                return "$" + item.getSalary();
            default:
                throw new IllegalArgumentException("Unexpected columnIndex");
        }
    }

    @Override
    public String getColumnName(int column) {
        // TODO complete this
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Name";
            case 2:
                return "Email address";
            case 3:
                return "Job title";
            case 4:
                return "Reports to";
            case 5:
                return "Salary";
            default:
                throw new IllegalArgumentException("Unexpected column");
        }
    }

    // *** Exercise Four below this point ***
    // TODO (optional) override and implement isCellEditable(), setValueAt()

}
