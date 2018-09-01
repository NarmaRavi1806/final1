package com.cg.capstore.service;

import com.cg.capstore.bean.OrderBean;

public interface IPlacingOrderService {

	OrderBean CheckProductAvailability(Integer id);
	OrderBean placingOrderOfProduct(OrderBean orderBean, String couponCode);
}
