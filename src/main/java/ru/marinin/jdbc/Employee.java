package ru.marinin.jdbc;

public class Employee {
    String id;
    String name;
    String departmentID;

    public Employee() {
    }

    public Employee(String id, String name, String departmentID) {
        this.id = id;
        this.name = name;
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentID=" + departmentID +
                '}';
    }
}
