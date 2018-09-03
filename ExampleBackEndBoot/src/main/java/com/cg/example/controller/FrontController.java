package com.cg.example.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.example.beans.DiscountBean;
import com.cg.example.beans.FeedbackProductBean;
import com.cg.example.beans.ImageBean;
import com.cg.example.beans.ProductBean;
import com.cg.example.beans.PromosBean;

@RestController
public class FrontController {

	@RequestMapping("/")
	public String consume(){
		return "REST Consumer";
	}
	
	@RequestMapping(value="/DiscountDetails")
	public ModelMap showWelcomePage(String id, ModelMap model){
		
		RestTemplate restTemplate = new RestTemplate();
		DiscountBean discount = restTemplate.getForObject("http://localhost:9090/getbyDiscountId?discountId="+id, DiscountBean.class);
		System.out.println(discount);
		model.put("discount", discount);
		return model;
	}
	
	@RequestMapping(value="/ProductDetails")
	public ModelMap findByProductId(String id, ModelMap model,ProductBean product1){
		
		RestTemplate restTemplate = new RestTemplate();
		ProductBean product = restTemplate.getForObject("http://localhost:9090/getProductdetailsById?productId="+id, ProductBean.class);
		System.out.println(product);
		model.put("product", product);
		return model;
	}
	
	@RequestMapping(value="/PromoDetails")
	public ModelMap findPromoById(String id, ModelMap model){
		
		RestTemplate restTemplate = new RestTemplate();
		PromosBean promo = restTemplate.getForObject("http://localhost:9090/viewPromoById?pId="+id, PromosBean.class);
		System.out.println(promo);
		model.put("promo", promo);
		return model;
	}
	
	@RequestMapping(value="/Categories")
	public ModelMap findByCategory(String id, ModelMap model){
		
		RestTemplate restTemplate = new RestTemplate();
		List<ProductBean> response = restTemplate.getForObject("http://localhost:9090/getProductbyCategory?category="+id, List.class);
		System.out.println(response);
		model.put("products", response);
		return model;
	}
	
	/*@RequestMapping(value="/discountadd")
	public DiscountBean consumeMessage(){
		DiscountBean discount=new DiscountBean();
		discount.setDiscountId("DS70");
		discount.setDiscountPercent(70);
		discount.setTimePeriod(Date.valueOf("2018-09-03"));
		RestTemplate restTemplate = new RestTemplate();
		DiscountBean discount1 = restTemplate.postForObject("http://localhost:9090/adddiscount",discount, DiscountBean.class);
		return discount1;
	}*/
	
	@RequestMapping(value="/viewByid")
	public DiscountBean viewByDiscountId(){
		RestTemplate restTemplate = new RestTemplate();
		DiscountBean message = restTemplate.getForObject("http://localhost:9090/getbyDiscountId?discountId=DS50", DiscountBean.class);
		
		
		return message;
	}
	
	@RequestMapping(value="/addDiscount",method=RequestMethod.POST)
	DiscountBean addDiscountByMerchant(Model model,DiscountBean discount) {
		model.addAttribute("discount", discount);
		System.out.println(discount.toString());
		RestTemplate restTemplate = new RestTemplate();
		
		DiscountBean str=restTemplate.postForObject("http://localhost:9090/adddiscount", discount, DiscountBean.class);
		
		return str;
	}
	
	@RequestMapping(value="/addPromo",method=RequestMethod.POST)
	Model addPromoByMerchant(Model model,PromosBean promo) {
		model.addAttribute("promo", promo);
		System.err.println(promo);
		System.err.println("sending..");
		RestTemplate restTemplate = new RestTemplate();
		String promoBean=restTemplate.postForObject("http://localhost:9090/addpromo", promo, String.class);
		System.err.println("Got data.."+promoBean);
		//model.addAttribute("promoBean", promoBean);
		return model;
	}
	
	@RequestMapping(value="/addProduct",method = RequestMethod.POST)
	ProductBean addProductByMerchant(Model model,ProductBean productBean/*,ImageBean imageBean,FeedbackProductBean feedback*/,PromosBean promoBean,DiscountBean discount) {
		
		model.addAttribute("product",productBean);
		/*model.addAttribute("image",imageBean);
		model.addAttribute("feedback",feedback);*/
		model.addAttribute("promoCode", promoBean);
		model.addAttribute("discount", discount);
		System.out.println(productBean.toString());
		RestTemplate restTemplate = new RestTemplate();
		
		ProductBean productBean1=restTemplate.postForObject("http://localhost:9090/addNewProduct", productBean, ProductBean.class);
		return productBean1;
		
	}
	
	@RequestMapping(value="/updateProduct",method = RequestMethod.PUT)
	String updateProductByMerchant(Model model,ProductBean productBean,ImageBean imageBean,FeedbackProductBean feedback,PromosBean promoBean,DiscountBean discount) {
		
		model.addAttribute("product",productBean);
		model.addAttribute("image",imageBean);
		model.addAttribute("feedback",feedback);
		model.addAttribute("promoCode", promoBean);
		model.addAttribute("discountId", discount);
		System.out.println(productBean.toString());
		RestTemplate restTemplate = new RestTemplate();
		
		String str=restTemplate.postForObject("http://localhost:9090/updateProductDetails", productBean, String.class);
		return str;
		
	}
	
	@RequestMapping("/ViewAllDiscounts")
	public ModelMap viewAllDiscounts(ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();
		List<DiscountBean> response = restTemplate.getForObject("http://localhost:9090/viewAllDiscounts", List.class);
		model.put("discount", response);
		return model;
	}
	
	@RequestMapping("/ViewAllPromos")
	public ModelMap viewAllPromos(ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();
		List<PromosBean> response = restTemplate.getForObject("http://localhost:7776/viewallcust", List.class);
		model.put("promo", response);
		return model;
	}
	
	@RequestMapping("/ViewAllProducts")
	public ModelMap viewAllProducts(ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();
		List<ProductBean> response = restTemplate.getForObject("http://localhost:9090/displayAllProducts", List.class);
		model.put("product", response);
		return model;
	}
	
	@RequestMapping("/ViewAllCategories")
	public ModelMap viewAllProductsByCategories(ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();
		List<ProductBean> response = restTemplate.getForObject("http://localhost:9090/displayAllCategory", List.class);
		model.put("product", response);
		return model;
	}
	
	@RequestMapping(value="/RemoveProduct",method = RequestMethod.DELETE)
	public String removeProductByMerchant(ProductBean productBean,String id) {
		RestTemplate restTemplate = new RestTemplate();
		String str=restTemplate.postForObject("http://localhost:9090/deleteProduct?productId="+id, productBean, String.class);
		return str;
		
	}
	
	@RequestMapping(value="/RemoveCategory",method = RequestMethod.DELETE)
	public String removeCategoryByMerchant(ProductBean productBean,String id) {
		RestTemplate restTemplate = new RestTemplate();
		String str=restTemplate.postForObject("http://localhost:9090/removeExistingCategory?category="+id, productBean, String.class);
		return str;
		
	}
	/*@RequestMapping(value = "/addingFeedback", method = RequestMethod.POST)
	public List<FeedbackProductBean> addingFeedback(Model model,String productId, FeedbackProductBean feedbackProductBean)
			 {
		
		model.addAttribute("feedback", feedbackProductBean);
		//model.addAttribute("product", productId);
		System.out.println("feedback"+feedbackProductBean);
		System.out.println("productid"+productId);
		RestTemplate restTemplate = new RestTemplate();
		List<FeedbackProductBean>feedback = restTemplate.postForObject("http://localhost:9010/addingFeedback?productId="+productId,feedbackProductBean, List.class);
		System.out.println("feedback result"+feedback);
		
		return feedback;
	}*/
	
	
}