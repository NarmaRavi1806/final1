package com.cg.capstore.service;

import com.cg.capstore.bean.DiscountBean;

public interface IDiscountService {

	DiscountBean discountDB(DiscountBean discount);
	public DiscountBean viewDiscountById(String discountId);

}
