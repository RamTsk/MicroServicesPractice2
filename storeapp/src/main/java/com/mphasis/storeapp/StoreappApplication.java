package com.mphasis.storeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class StoreappApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(StoreappApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO PC_PRODUCTS VALUES(1001,'Samsung',19999.99)";
		int count = jdbcTemplate.update(sql);
		if(count>0) {
			System.out.println("Added Records into Table");
		}
	}
}
