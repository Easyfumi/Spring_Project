package ru.marinin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.marinin.Trafficlight.Trafficlight;

import javax.xml.crypto.Data;
import java.util.function.Predicate;

@SpringBootApplication
public class SpringTasksApplication {

	public static void main(String[] args) {

		//SpringApplication.run(SpringTasksApplication.class, args);

		ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.marinin");

		Object task811 = ctx.getBean("hello");
		System.out.println(task811);

//		while (true) {
			Object task812_1 = ctx.getBean("randomInt");
			System.out.println(task812_1);
//		}


		Object task813 = ctx.getBean("getStartDate");
		System.out.println(task813);

		Predicate<Integer> task814 = (Predicate<Integer>) ctx.getBean("gradesRange");
		System.out.println(task814.test(3));

		Object task815_max = ctx.getBean("max");
		System.out.println(task815_max);

		Object task815_min = ctx.getBean("min");
		System.out.println(task815_min);

		Trafficlight tr = ctx.getBean(Trafficlight.class);
		while (true) {
			System.out.println(tr.next());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
