package com.mphasis.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mphasis.storeapp.domain.Product;
import com.mphasis.storeapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository repository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Product addProduct(Product product) {
		String sql = "INSERT INTO PC_PRODUCTS VALUES("+product.getId()+","+product.getName()+","+product.getPrice()+")";
		int count = jdbcTemplate.update(sql);
		if (count>0) return product;
		return null;
	}

	@Override
	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product updateProductPrice(Integer productId, Double productPrice) {

		Product product=repository.findById(productId).get();

		product.setPrice(productPrice);

		return repository.save(product);
	}

	@Override
	public Product findProductById(Integer productId) {
		// TODO Auto-generated method stub
		return repository.findById(productId).get();
	}

	@Override
	public List<Product> findAllProducts() {
		return jdbcTemplate.query("SELECT * FROM pc_products", new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public void deleteProduct(Integer productId) {
		repository.deleteById(productId);

	}

}
