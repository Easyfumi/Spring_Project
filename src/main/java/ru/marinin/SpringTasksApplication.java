package ru.marinin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.marinin.Trafficlight.Trafficlight;
import ru.marinin.jdbc.*;
import ru.marinin.random.Random;

import java.io.FilterOutputStream;
import java.sql.*;
import java.util.function.Predicate;


public class SpringTasksApplication {

    public static void main(String[] args) {

//		Connection connection = DriverManager.getConnection("jdbc:h2:.\\Office");
//		EmployeeDAO employeeDAO = new EmployeeDAO(connection);
//		System.out.println(employeeDAO.getAllEmployee());
//		connection.close();

//		Connection connection = DriverManager.getConnection("jdbc:h2:.\\Office");
//		DepartmentDAO departmentDAO = new DepartmentDAO(connection);
//		System.out.println(departmentDAO.getAllDepartments());
//		connection.close();

//		Connection connection = DriverManager.getConnection("jdbc:h2:.\\Office");
//
//		DAO<Department> departmentDAO = new DAO<>(connection, Department.class);
//		System.out.println(departmentDAO.getAll());
//
//		DAO<Employee> employeeDAO = new DAO<>(connection, Employee.class);
//		System.out.println(employeeDAO.getAll());


//        System.out.println(new AnnotationConfigApplicationContext("ru.marinin")
//                .getBean(Random.class));


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ru.marinin.random");
        Random random = (Random) applicationContext.
                getBean("random");
        System.out.println(random.randomInt(0, 101));
        System.out.println(random.randomInt(0, 101));
        System.out.println(random.randomInt(0, 101));
        System.out.println(random.randomInt(0, 101));


    }

}
