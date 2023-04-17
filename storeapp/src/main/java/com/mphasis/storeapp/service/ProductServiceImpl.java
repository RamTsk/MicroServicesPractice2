package com.mphasis.storeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.storeapp.domain.Product;

@Service
public class ProductServiceImpl implements IProductService {

@Autowired	
private IProductService ProductService;
	
	@Override
	public Product addProduct(Product product) {

		return null;
	}

	@Override
	public Product updateProduct(Product product) {
		return null;
	 }

	@Override
	public Product updateProductPrice(Integer productId, Double productPrice) {
		return null;
	}

	@Override
	public Product findProductById(Integer productId) {
		return null;
	}

	@Override
	public List<Product> findAllProducts() {
		return null;
	}

	@Override
	public void deleteProduct(Integer productId) {

	}

}
