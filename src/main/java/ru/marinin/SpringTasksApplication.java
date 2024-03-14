package ru.marinin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.marinin.Trafficlight.Trafficlight;

import java.util.function.Predicate;

@SpringBootApplication
public class SpringTasksApplication {

	public static void main(String[] args) {

		new AnnotationConfigApplicationContext("ru.marinin")
				.getBean(StreamingPlatform.class)
				.start();


	}

}
