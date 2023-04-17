package com.mphasis.storeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.storeapp.domain.Product;
import com.mphasis.storeapp.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

@Autowired	
private IProductService productService;


@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public List<Product> getAllProducts(){
	return productService.findAllProducts();
}

@GetMapping("/{id}")
public Product getProductById(@PathVariable("id")Integer productId){
	return productService.findProductById(productId);
}

@DeleteMapping("/{id}")
@ResponseStatus(code = HttpStatus.NO_CONTENT)

public void deleteProductById(@PathVariable("id")Integer productId){
productService.deleteProduct(productId);
}

@PatchMapping("/{id}/{price}")
public Product updateProductPrice(@PathVariable("id")Integer productId,@PathVariable("price") Double productPrice){
	return productService.updateProductPrice(productId, productPrice);
}


@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
public Product addProduct(@RequestBody Product product){
	return productService.addProduct(product);
}


@PutMapping
@ResponseStatus(code = HttpStatus.OK)
public Product updateProduct(@RequestBody Product product){
	return productService.updateProduct(product);
}


}
