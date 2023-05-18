package ictgradschool.industry.designpatterns.companydb.view;

import ictgradschool.industry.designpatterns.companydb.model.Employee;
import ictgradschool.industry.designpatterns.companydb.model.Manager;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EmployeeTreeAdapter implements TreeModel {

    public Employee root;

    public EmployeeTreeAdapter(Employee employee) {
        // TODO complete this
        this.root = employee;
    }

    @Override
    public Object getRoot() {
        // TODO complete this
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        // TODO complete this
        if (parent instanceof Manager)
        {
            return ((Manager) parent).getEmployees().get(index);
        }
        else {
            return null;
        }
    }

    @Override
    public int getChildCount(Object parent) {
        // TODO complete this
        if (parent instanceof Manager)
        {
            return ((Manager) parent).getEmployees().size();
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean isLeaf(Object node) {
        // TODO complete this
        if (node instanceof Manager)
        {
            if (((Manager) node).getEmployees().size() == 0)
            {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        // TODO complete this
        return ((Manager) parent).getEmployees().indexOf(child);
    }


    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // Unused
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        // Unused
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        // Unused
    }
}
