package app;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        employeeDAO.addEmployee("Vasyl Bilous", 24, "Department commander", 30000);
        employeeDAO.addEmployee("Andriy Velman", 26, "Senior gunner", 27000);
        employeeDAO.addEmployee("Vitaliy Mardanov", 24, "Gunner", 21000);

        System.out.println("Список співробітників: ");
        for (String emp : employeeDAO.getAllEmployees()) {
            System.out.println(emp);
        }

        employeeDAO.updateEmployeeSalary(1, 5500);

        employeeDAO.deleteEmployee(2);

        System.out.println("\nСписок після оновлення даних: ");
        for (String emp : employeeDAO.getAllEmployees()) {
            System.out.println(emp);
        }
    }
}
