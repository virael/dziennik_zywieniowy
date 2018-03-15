package pl.lukasz.janusz.conf;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import pl.lukasz.janusz.converter.LocalDateConverter;
import pl.lukasz.janusz.converter.LocalDateTimeConverter;


@EnableJpaRepositories(basePackages = "pl.lukasz.janusz.repository")
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"pl.lukasz.janusz.controller"})
@EnableWebMvc
public class AppConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		final LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("dziennikZywieniowyPersistenceUnit");
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean(name="localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
		
		final SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pl","PL"));
		
		return localeResolver; 
	}
	
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
	
	@Override
	   public void addFormatters(FormatterRegistry registry) {
	       registry.addConverter(new LocalDateConverter("yyyy-MM-dd")); //-HH.mm.ss.SSSSSS
	       registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"));
	   }
}