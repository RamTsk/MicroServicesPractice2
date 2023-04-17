package com.mphasis.storeapp.service;

import java.util.List;

import com.mphasis.storeapp.domain.Product;

public interface IProductService {

	Product addProduct(Product product);
	Product updateProduct(Product product);
	Product updateProductPrice(Integer productId,Double productPrice);
	Product findProductById(Integer productId);
	List<Product> findAllProducts();
	void deleteProduct(Integer productId);
	
	
}
