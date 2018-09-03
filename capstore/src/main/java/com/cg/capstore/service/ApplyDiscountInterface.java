package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.bean.DiscountBean; 

public interface ApplyDiscountInterface {

	DiscountBean addDiscount(DiscountBean discount);
	DiscountBean viewDiscountById(String discountId);
	List<DiscountBean> findAllDiscounts();
}
