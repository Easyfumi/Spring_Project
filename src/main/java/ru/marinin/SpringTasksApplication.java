package ru.marinin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.marinin.Trafficlight.Trafficlight;
import ru.marinin.defaultPackage.ClassForTestDefault;
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

            // 8.3.1 NAME
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ru.marinin");
//        System.out.println(applicationContext.getBean(Student.class));

            // 8.3.6 RANDOM
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ru.marinin.random");
//        Random random = (Random) applicationContext.
//                getBean("random");
//        System.out.println(random.randomInt(0, 101));
//        System.out.println(random.randomInt(0, 101));
//        System.out.println(random.randomInt(0, 101));
//        System.out.println(random.randomInt(0, 101));

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ru.marinin.defaultPackage");
        ClassForTestDefault objForTest = applicationContext.getBean(ClassForTestDefault.class);
        System.out.println(objForTest.x);
        System.out.println(objForTest.random.randomInt(0, 100));
        System.out.println(objForTest.random.randomInt(0, 100));
        System.out.println(objForTest.random.randomInt(0, 100));
        System.out.println(objForTest);







    }

}
