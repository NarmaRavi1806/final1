package com.cg.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.DiscountBean;
import com.cg.capstore.service.IDiscountService;

@RestController
public class DicountController {
	
	@Autowired
	private IDiscountService discountService;

	@RequestMapping(value = "/adddiscount", method = RequestMethod.POST)
	public DiscountBean discountDB(@RequestBody DiscountBean discount) {

		return discountService.discountDB(discount);
	}
	
	@RequestMapping(value = "/getbyDiscountId")
	public DiscountBean viewDiscountById(String discountId) {
		
		return discountService.viewDiscountById(discountId);
		
	}
}
