package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.bean.PromosBean;

public interface PromoDisplayService {

	String addPromo(PromosBean promoss);
	PromosBean viewById(String pId);
	List<PromosBean> viewAllPromos();
}
