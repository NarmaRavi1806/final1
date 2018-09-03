package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.capstore.bean.PromosBean;
import com.cg.capstore.repo.PromoRepository;

@Component(value="promoServices")
public class PromoServiceImpl implements PromoDisplayService{
	@Autowired
	PromoRepository promo;

	@Override
	public String addPromo(PromosBean promoss) {
		promo.save(promoss);
		return promoss.getPromoCode()+" is added ";
	}

	@Override
	public PromosBean viewById(String pId) {
		return promo.getOne(pId);
	}

	@Override
	public List<PromosBean> viewAllPromos() {
		return promo.findAll();
	}
	
	

}
