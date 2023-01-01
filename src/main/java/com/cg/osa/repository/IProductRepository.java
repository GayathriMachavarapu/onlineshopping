package com.cg.osa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.osa.dto.ProductDTO;

public interface IProductRepository extends JpaRepository<ProductDTO,Integer>{
//	@Query(value="select p from ProductDTO  p where p.product_id IN(select p1.productDTO from CategoryDTO p1 where p1.category_table.catname = :catName)")
//	List<ProductDTO> viewProductByCategoryName(@Param("catName") String catname);


}
