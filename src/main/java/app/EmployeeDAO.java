package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Метод додавання співробітника
    public void addEmployee(String name, int age, String position, int salary) {
        String query = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, position);
            preparedStatement.setFloat(4, salary);
            preparedStatement.executeUpdate();

            System.out.println("Cпівробітника додано!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод отримання інформації про співробітників
    public List<String> getAllEmployees() {
        List<String> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";

        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                employees.add(resultSet.getInt("id") + " | " + resultSet.getString("name") +
                        " | " + resultSet.getInt("age") + " | " +
                        resultSet.getString("position") + " | " + resultSet.getFloat("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Метод оновлення інформації
    public void updateEmployeeSalary(int id, float newSalary) {
        String query = "UPDATE employees SET salary = ? WHERE id = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setFloat(1, newSalary);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            System.out.println("Зарплату оновлено!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Співробітника видалено!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
