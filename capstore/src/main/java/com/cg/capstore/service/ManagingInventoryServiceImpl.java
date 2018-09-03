package com.cg.capstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.repo.ProductRepo;
@Service
public class ManagingInventoryServiceImpl implements IManagingInventoryService{
	@Autowired
	ProductRepo productInventoryRepo;
	
	@Override
	public List<ProductBean> displayListOfProducts() {
		
		return productInventoryRepo.findAll();
	}
	@Override
	public ProductBean addNewProduct(ProductBean product) {
		
		
		
		return productInventoryRepo.save(product);
	}
	@Override
	public ProductBean updateProductDetails(ProductBean product) {
		
		ProductBean product1= productInventoryRepo.getOne(product.getProductId());
		product1.setProductName(product.getProductName());
		product1.setCategory(product.getCategory());
		product1.setDiscount(product.getDiscount());
		product1.setProductId(product.getProductId());
		product1.setPrice(product.getPrice());
		product1.setQuantity(product.getQuantity());
		product1.setImageId(product.getImageId());
		return productInventoryRepo.save(product1);
	}
	@Override
	public String deleteProduct(String productId) {
		System.err.println(productInventoryRepo.getOne(productId));
		productInventoryRepo.deleteById(productId);
		
		return productId+" is removed from the list";
		}
	@Override
	public ProductBean getProductdetailsById(String productId) {
		
		return productInventoryRepo.getOne(productId);
	}
	
	
	@Override
	public String removeExistingCategory(String categoryId) {
	
		productInventoryRepo.deleteById(categoryId);
		return categoryId+" category is deleted";
	}
	@Override
	public List<ProductBean> displayAllCategory() {
		
		return productInventoryRepo.getSimilarCategory();
	}
	@Override
	public List<ProductBean> viewByCategory(String category) {
		
		return productInventoryRepo.viewByCategory(category);
	}
	
	
	
}
