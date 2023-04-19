package com.mphasis.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.storeapp.domain.Product;
import com.mphasis.storeapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository repository;

	@Override
	public Product addProduct(Product product) {
		return repository.save(product);
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
		return repository.findAll();
	}

	@Override
	public void deleteProduct(Integer productId) {
		repository.deleteById(productId);

	}

}
