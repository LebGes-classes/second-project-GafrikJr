package org.example.methods.userMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.model.users.Employee;
import java.util.List;

public class EmployeeMethods {
    public static void hireEmployee(Employee employee) {
        HibernateMethods.createEntry(employee, Employee.class);
    }


    // тут создаем рабочих и сразу добавляем записи в БД
    public static int hireStaff(int warehouseId, int staffSize, String post) {
        Employee manager = new Employee(warehouseId, "manager");
        hireEmployee(manager);
        for (int i = 0; i < staffSize - 1; i++) {
            Employee employee = new Employee(warehouseId, post);
            hireEmployee(employee);
        }
        return manager.getId();
    }

    public static void fireEmployeeById(int id) {
        Employee employee = getEmployeeById(id);
        HibernateMethods.updateEntity(id, Employee.class, _employee -> fireEmployee(_employee));
    }

    public static void fireStaff(int warehouseId) {
        String request = "FROM Employee where placeOfWorkId = " + warehouseId;
        List<Employee> staff = HibernateMethods.getObjectsByRequest(Employee.class, request);
        for (Employee employee : staff) {
            HibernateMethods.updateEntity(employee.getId(), Employee.class, _employee -> fireEmployee(_employee));
        }
    }

    public static Employee getEmployeeById(int employeeId) {
        return HibernateMethods.getObjectById(employeeId, Employee.class);
    }

    // по законодателству нельзя удалять информацию о рабочих, поэтому ставим им по 0 в двух столбцах
    private static void fireEmployee(Employee employee) {
        employee.setPlaceOfWorkId(0);
        employee.setWorking(false);
    }

}
