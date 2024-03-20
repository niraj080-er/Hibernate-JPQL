package org.jsp.OneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByBrandName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Product Brand Name ? ");
		String pName = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1, pName);
		try {
			List<Product> prod = q.getResultList();
			if (prod.size() != 0) {
				for (Object product : prod) {
					System.out.println(product);
				}
			} else {
				System.out.println("Invalid Brand Name ? ");
			}
		} catch (NoResultException e) {
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid Brand Name ? ");
		}
		sc.close();
	}


}
