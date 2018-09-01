package com.cg.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.service.IReturnGoodsService;

@RestController
public class ReturnGoodsController {

	@Autowired
	IReturnGoodsService returnGoodsService;
	
	@RequestMapping(value="/returnPurchasedProduct", method=RequestMethod.POST)
	public OrderBean returnProduct(Integer id) {
		
		return returnGoodsService.returnProduct(id);
	}
	
	@RequestMapping(value="/getDeliveryStatus", method=RequestMethod.GET)
	public String getDeliveryStatus(Integer orderId) {
		
		return returnGoodsService.getDeliveryStatus(orderId);
	}
}
