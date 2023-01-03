package com.cg.osa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.osa.dto.ProductDTO;
@Repository
public interface IProductRepository extends JpaRepository<ProductDTO,Integer>{
	

}
