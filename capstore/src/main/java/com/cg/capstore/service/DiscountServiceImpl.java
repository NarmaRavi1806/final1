package com.cg.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.capstore.bean.DiscountBean;
import com.cg.capstore.repo.DiscountRepo;

@Service
public class DiscountServiceImpl implements IDiscountService {
	
	@Autowired
	DiscountRepo repo;

	@Override
	public DiscountBean discountDB(DiscountBean discount) {		
		return repo.save(discount);
	}
	
	@Override
	public DiscountBean viewDiscountById(String discountId) {
		
		return repo.getOne(discountId);
	}

}


