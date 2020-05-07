package com.capgemini.go.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.go.dto.ProductDTO;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addProduct(ProductDTO product) {
		boolean status=false;
		sessionFactory.getCurrentSession().save(product);
		status=true;
		return status;
	}

	@Override
	public boolean deleteProduct(String productID){
		boolean status=false;
		Session currentSession=sessionFactory.getCurrentSession();
		Query<ProductDTO> query=currentSession.createQuery("from ProductDTO where product_id=:product_id",ProductDTO.class);
		query.setParameter("product_id", productID);
		ProductDTO product=query.uniqueResult();
		currentSession.delete(product);
		status=true;
		return status;
	}

	@Override
	public boolean editProduct(ProductDTO product) {
		boolean status=false;
		sessionFactory.getCurrentSession().update(product);
		status=true;
		return status;
	}

	@Override
	public List<ProductDTO> viewAllProduct(){
		Session currentSession=sessionFactory.getCurrentSession();
		Query<ProductDTO> query=currentSession.createQuery("from ProductDTO",ProductDTO.class);
		return query.getResultList();
	}

	@Override
	public List<ProductDTO> grtProductByID(ProductDTO product) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<ProductDTO> query=currentSession.createQuery("from ProductDTO where product_id=:product_id",ProductDTO.class);
		query.setParameter("product_id", product.getProduct_id());
		return query.getResultList();
	}

	


}
