package org.jsp.OneToManyUni;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchantAndProduct {
	public static void main(String[] args) {
		Merchant m= new Merchant();
		m.setName("ram pvt ltd");
		m.setGst_number("GISTINRAM213");
		m.setPhone(6280458043L);
		m.setPassword("niraj@123");
		
		Product p=new Product();
		p.setName("Laptop");
		p.setBrand("Asus");
		p.setCategory("Electronic");
		p.setDescription("6GB RAM");
		p.setCost(123454);
		p.setMerchant(m);
		
		Product p1=new Product();
		p1.setName("Laptop");
		p1.setBrand("HP");
		p1.setCategory("Electronic");
		p1.setDescription("6GB RAM");
		p1.setCost(123454);
		p1.setMerchant(m);
		
		
		Product p2=new Product();
		p2.setName("Laptop");
		p2.setBrand("DELL");
		p2.setCategory("Electronic");
		p2.setDescription("6GB RAM");
		p2.setCost(123854);
		p2.setMerchant(m);
		
		Product p3=new Product();
		p3.setName("mobile");
		p3.setBrand("Apple");
		p3.setCategory("Electronic");
		p3.setDescription("6GB RAM");
		p3.setCost(153454);
		p3.setMerchant(m);
		
		m.setProducts(Arrays.asList(p,p1,p2,p3));
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(m);
		transaction.begin();
		transaction.commit();
	}

}
