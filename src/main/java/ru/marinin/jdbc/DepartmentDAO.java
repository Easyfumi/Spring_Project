package ru.marinin.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    Connection connection;


    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Department> getAllDepartments() throws Exception{
        List<Department> departments = new ArrayList<>();
        Statement stm = connection.createStatement();
        ResultSet res = stm.executeQuery("SELECT * FROM Department");
        while (res.next()) {
        //    departments.add(new Department(res.getInt(1), res.getString(2)));
        }
        return departments;
    }

    public void addDepartment(Department department) throws Exception{
            PreparedStatement stm = connection.prepareStatement("INSERT INTO Department VALUES(?,?)");
    //        stm.setInt(1,department.id);
            stm.setString(2, department.name);
            stm.execute();
    }

    public void deleteDepartment(Department department) throws Exception{

    }

    public void updateDepartment(Department department) throws Exception{

    }

    public Employee findDepartmentByID(int id) throws Exception{
        return null;
    }
}
