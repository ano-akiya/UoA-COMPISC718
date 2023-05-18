# Industry Lab: Design Patterns

In today's lab, you'll be working to create the beginnings of an employee database Swing application. The app will be able to display information about employees in a GUI, including who their managers are. Each exercise will involve adding a little more functionality to the app.

In addition to the code which you must complete, a set of unit tests has been provided which should help you debug any errors. The unit tests which should pass at the end of each lab exercise are given in the corresponding exercise.


## Exercise One: Employees and Managers
In this exercise, you'll begin by completing the "data objects" to be used by the app - the `Employee` and `Manager` classes. These classes should be implemented following the *composite* design pattern: each `Manager` is a special kind of `Employee` who can also manage other employees. Each `Employee` also knows who its manager is.

To begin, skeleton code for the two classes is given to you. Complete this code by following these steps:

1. Add necessary fields to the `Employee` and `Manager` classes, and complete the constructors which should populate those fields.

2. Add necessary *getter* methods to `Employee`. `TestEmployeeAndManager.testGetters()` can show you which getters you need.

3. Complete all method skeletons provided in the `Employee` and `Manager` classes. To understand what each method should do, please read the method comments, and look at the unit tests (each method to implement has at least one unit test associated with it).

When complete, all unit tests in the `TestEmployeeAndManager` class should pass. **Note:** Having these tests pass is a good indication that your code is correct, but not a guarantee - you should still have your code checked by a tutor if you're unsure!

**Hint:** Some of the method comments contain hints about how the corresponding methods can be implemented. Make sure to read them if you're stuck! You can also carefully examine the unit tests to see what the results of various methods should be for various inputs.


## Exercise Two: Displaying employees in a JTree
In this exercise, we'll get our employment hierarchy displayed to the user in a `JTree`.

`JTree` pulls the data it displays from an instance of a `TreeModel`. However, we have a `Manager` that we want to display, rather than a `TreeModel` (called `ceo` in `EmployeeApp`'s `initGui()` method). This means we must create an *adapter* to allow an `Employee` to be displayed in a `JTree`.

For this exercise, complete the `EmployeeTreeAdapter`, a skeleton of which has been provided to you. Use the unit tests in `TestEmployeeTreeModel`, plus the [TreeModel documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/tree/TreeModel.html), to guide you. For this exercise, you may ignore the `valueForPathChanged()`, `addTreeModelListener()`, and `removeTreeModelListener()` methods (i.e. leave them blank).

Once all `TestEmployeeTreeModel` unit tests pass, then appropriately modify `EmployeeApp.initGui()` so that an instance of `EmployeeTreeAdapter` is used to display the provide `ceo` in the `tree`.


## Exercise Three: Displaying employees in a JTable
In this exercise, we'll get our employee details displayed to the user in a `JTable`.

Similarly to Exercise Three above, we want to display information in a `JTable`, but these tables get their information from a `TableModel` whereas we have an `Employee` instead. We must again create an adapter.

For this exercise, complete the `EmployeeTableAdapter`, a skeleton of which has been provided to you. Use the unit tests in `TestEmployeeTableModel`, plus the [TableModel documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/table/TableModel.html), to guide you.

Once all `TestEmployeeTableModel` unit tests pass, then appropriately modify `EmployeeApp.initGui()` so that an instance of `EmployeeTableAdapter` is used to display the provide `ceo` in the `table`.

**Hint:** What `Manager` method, which you implemented in Exercise One, could be used to get a list of *all* employees?


## Challenge Exercise Four: Editing a JTable
Now that we've gotten our data displayed in the `JTable`, let's further modify our app to allow us to *edit* the data that's there.

To do this, further investigate the `TableModel` documentation - in particular, the `isCellEditable()` and `setValueAt()` methods (you won't see them in the provided skeleton because they have default implementations - which do nothing - in the `AbstractTableModel` class we're extending).

Start by modifying the `EmployeeTableAdapter` class so an employee's email address, job title, and salary are editable. Then, for an extra challenge, work on the "Reports to" column. Your code should identify an employee based on a provided name (you may assume names are unique for this exercise), and modify things accordingly. If a blank name is entered, that employee should then be given no manager.

Finally, allow an employee's name to be edited. When doing so, you might notice a problem when editing names. If the employee in question has nobody reporting to them, you won't notice an issue. However, if the employee whose name you edit manages other employees, the manager's new name might not show up on the table in the "Reports to" column of that manager's employees (until we click on that employee's row). Think about why this might be, and record your answer here / in your journal.


## Challenge Exercise Five: Ensuring consistency between views
In this exercise, we'll fix the bug identified at the end of Exercise Four, and another bug - you'll notice that if you edit any data in the table, the *tree* at the very least will not display the updated names / emails, and may completely break altogether!

This is because, when the employee data changes, the tree (which should now display the changed data) has no idea that the change occurred, which leaves it in an inconsistent state.

To fix this, we need to adopt a new design pattern: *Model-View-Controller (MVC)*. Essentially, we need to set up `Employee` and `Manager` so that they can notify any interested *listeners* / *observers* of any changes. Then, in the adapter classes, we need to convert these messages into *tree* or *table* events which are supplied to the `JTree` and `JTable` so they know to re-render themselves.

**Note:** You will cover MVC in the next lab, but if you'd like to explore this yourself, you're welcome to give it a try now! Alternatively, come back to this exercise as further practice once you've completed the next design patterns lab.


## Challenge Exercise Six: More functionality
There are many ways we could extend this app further. For example:

- Allowing users to add new employees or remove existing ones
- Allowing users to "drag and drop" nodes in the `JTree` to reassign employees to different managers
- Changing the "Reports to" column to display a combo box rather than a text box, only allowing the user to select from "N/A" or a valid manager, rather than allowing them to type anything
- etc.

Further expand your Swing and Design Patterns knowledge by implementing some or all of these features, plus any of your own that you can think of!