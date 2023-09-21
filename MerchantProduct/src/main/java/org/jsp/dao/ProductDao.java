package org.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Merchant;
import org.jsp.dto.Product;

public class ProductDao {
	public EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public Product saveProduct(Product p, int merch_id) {
		Merchant m = manager.find(Merchant.class, merch_id);
		if (m != null) {
			m.getProducts().add(p);
			p.setMerchants(m);
			manager.persist(m);
			EntityTransaction t = manager.getTransaction();
			t.begin();
			t.commit();
			return p;
		} else
			return null;
	}

	public Product updateProduct(Product p, int merch_id) {
		Merchant m = manager.find(Merchant.class, merch_id);
		if (m != null) {
			m.getProducts().add(p);
			p.setMerchants(m);
			manager.merge(m);
			EntityTransaction t = manager.getTransaction();
			t.begin();
			t.commit();
			return p;
		} else
			return null;
	}

	public Product findById(int id) {
		return manager.find(Product.class, id);
	}
	public List<Product> findByMId(int mid) {
		Query q = manager.createQuery("select p from Product p where p.merchant_id=?1");
		q.setParameter(1, mid);
		if (q.getResultList() != null) {
			return q.getResultList();
		} else
			return null;
	}
	

	public List<Product> findByBrand(String brand) {
		Query q = manager.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1, brand);
		if (q.getResultList() != null) {
			return q.getResultList();
		} else
			return null;
	}

	public List<Product> findByCat(String category) {
		Query q = manager.createQuery("select p from Product p where p.category=?1");
		q.setParameter(1, category);
		List<Product> prod=q.getResultList();
		if (prod != null) {
			return q.getResultList();
		} else
			return null;
	}

}
