package com.cg.capstore.service;

import com.cg.capstore.bean.OrderBean;

public interface IReturnGoodsService {
	OrderBean returnProduct(Integer id); 
	public String getDeliveryStatus (Integer orderId);
}
