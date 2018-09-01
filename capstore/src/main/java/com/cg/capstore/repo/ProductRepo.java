package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.ProductBean;

@Repository
public interface ProductRepo extends JpaRepository<ProductBean, String>{

}
