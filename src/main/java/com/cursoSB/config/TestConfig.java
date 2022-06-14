package com.cursoSB.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursoSB.entities.Category;
import com.cursoSB.entities.Order;
import com.cursoSB.entities.Product;
import com.cursoSB.entities.User;
import com.cursoSB.entities.unums.OrderStatus;
import com.cursoSB.repository.CategoryRepository;
import com.cursoSB.repository.OrderRepositoty;
import com.cursoSB.repository.ProductRepository;
import com.cursoSB.repository.UserRepositoty;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{
	
	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE USERREPOSITORY;
	private UserRepositoty userRepositoty;
	
	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE USERREPOSITORY;
	private OrderRepositoty orderRepositoty;
	
	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE USERREPOSITORY;
	private CategoryRepository categoryRepository;
	
	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE USERREPOSITORY;
	private ProductRepository roductRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		userRepositoty.saveAll(Arrays.asList(u1, u2));
		orderRepositoty.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		roductRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
	}
	
	
	
	
}
		
