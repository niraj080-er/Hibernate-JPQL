package org.jsp.OneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByCategory {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Product Category ? ");
		String pCategory = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select p from Product p where p.category=?1");
		q.setParameter(1, pCategory);
		try {
			List<Product> prod = q.getResultList();
			if (prod.size() != 0) {
				for (Object product : prod) {
					System.out.println(product);
				}
			} else {
				System.out.println("Invalid category Name ? ");
			}
		} catch (NoResultException e) {
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid category Name ? ");
		}
		sc.close();
	}

}
