package ru.marinin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.marinin.Trafficlight.Trafficlight;

import java.util.function.Predicate;

@SpringBootApplication
public class SpringTasksApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.marinin");
		ctx.getBean(StreamingPlatform.class);

	}

}
