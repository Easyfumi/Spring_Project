package ru.marinin.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> getAllEmployee() throws Exception{
        List<Employee> employees = new ArrayList<>();
            Statement stm = connection.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM Employee");
            while (res.next()) {
        //        employees.add(new Employee(res.getInt(1), res.getString(2), res.getInt(3)));
            }
        return employees;
    }

    public void addEmployee(Employee employee) throws Exception{
        try (Connection connection = DriverManager.getConnection("jdbc:h2:.\\Office");) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO Employee VALUES(?,?,?)");
        //    stm.setInt(1,employee.id);
            stm.setString(2, employee.name);
        //    stm.setInt(3,employee.departmentID);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmployee(Employee employee) throws Exception{

    }

    public void updateEmployee(Employee employee) throws Exception{

    }

    public Employee findEmployeeByID(int id) throws Exception{
        return null;
    }

}
