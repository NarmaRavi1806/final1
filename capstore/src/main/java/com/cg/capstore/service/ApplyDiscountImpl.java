package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.capstore.bean.DiscountBean;
import com.cg.capstore.repo.DiscountRepo;

@Service
public class ApplyDiscountImpl implements ApplyDiscountInterface {
	@Autowired
	DiscountRepo repo;

	@Override
	public DiscountBean addDiscount(DiscountBean discount) {		
		return repo.save(discount);
	}

	@Override
	public DiscountBean viewDiscountById(String discountId) {		
		return repo.getOne(discountId);
	}

	@Override
	public List<DiscountBean> findAllDiscounts() {
		return repo.findAll();
	}

}
