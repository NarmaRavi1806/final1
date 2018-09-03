package com.cg.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.capstore.bean.PromosBean;
import com.cg.capstore.service.PromoDisplayService;

@RestController
public class PromoController {

	@Autowired
	PromoDisplayService service;
	
	@RequestMapping(value = "/addpromo", method = RequestMethod.POST)
	public String promoDb(@RequestBody PromosBean promoss) {
		System.err.println("Back"+promoss.toString());
		return service.addPromo(promoss);
	}
	
	@RequestMapping(value = "/viewPromoById", method = RequestMethod.GET)
	public PromosBean viewById(String pId) {
		return service.viewById(pId);
	}
	
	@RequestMapping(value = "/viewAllPromos", method = RequestMethod.GET)
	public List<PromosBean> viewAllPromos(){
		return service.viewAllPromos();
	}
}
