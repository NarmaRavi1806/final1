package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.repo.ReturnGoodsRepo;

@Service
public class ReturnGoodsServiceImpl implements IReturnGoodsService {

	@Autowired
	ReturnGoodsRepo returnGoodsRepo;
	@Override
	public OrderBean returnProduct(Integer order) {
		
	 OrderBean orderBean= returnGoodsRepo.getOne(order);
	 if(orderBean.getOrderStatus().equalsIgnoreCase("Delivered")) {
		 orderBean.setOrderStatus("Returned");
		 
		 List<ProductBean> returningProcess = orderBean.getProduct();
		 
		 for (ProductBean productBean : returningProcess) {
			
			 int quantity = productBean.getQuantity() + 1;
			 productBean.setQuantity(quantity);
			 
		}
	 }
	 return returnGoodsRepo.save(orderBean);
		
	}
	
	@Override
	public String getDeliveryStatus(Integer orderId) {
		OrderBean oDetails=returnGoodsRepo.getOne(orderId);
		String status=oDetails.getOrderStatus();
		return status;
	}

}
