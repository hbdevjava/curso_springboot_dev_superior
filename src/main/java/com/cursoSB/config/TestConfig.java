package com.cursoSB.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursoSB.entities.User;
import com.cursoSB.repository.UserRepositoty;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{
	
	@Autowired //ESSA ANOTAÇAO CRIA UMA DEPENDENCIA DA INTERFACE USERREPOSITORY;
	private UserRepositoty userRepositoty;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepositoty.saveAll(Arrays.asList(u1, u2));
		
		
	}
		
	
	
}
