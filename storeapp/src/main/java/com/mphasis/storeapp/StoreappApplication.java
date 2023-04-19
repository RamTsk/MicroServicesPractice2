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
		String sql = "INSERT INTO pc_products (id, name, product_price) VALUES (?, ?, ?)";
		int result;
		result = jdbcTemplate.update(sql, "1001", "LG", "10345.66");
		result = jdbcTemplate.update(sql, "1002", "APPLE", "10599.99");
		result = jdbcTemplate.update(sql, "1003", "NOKIA", "12345.00");
		result = jdbcTemplate.update(sql, "1004", "ONIDA", "10300.00");
		result = jdbcTemplate.update(sql, "1005", "SAMSUNG", "10250.00");
		if (result > 0) {
			System.out.println("A new row has been inserted.");
		}
	}
}
