package pl.lukasz.janusz.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.lukasz.janusz.conf.AppConfiguration;

public class SpringDiApplication {

	public static void main(String[] args) {
	
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
		
			context.register(AppConfiguration.class);
			context.refresh();
		
			final EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
			
			final EntityManager em = emf.createEntityManager();
			
			System.out.println("Create entitymanager: " + em);
			
			em.close();
		}
	}
}
