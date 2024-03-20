package org.jsp.OneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FilterProductBWRange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Product Minimum Range ? ");
		double minPrice=sc.nextDouble();
		System.out.println("Enter the Product Maximum Range ? ");
		double maxPrice=sc.nextDouble();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select p from Product p where p.cost>=?1 and p.cost<=?2");
		q.setParameter(1, minPrice);
		q.setParameter(2, maxPrice);
		
		try {
			List<Product> prod = q.getResultList();
			if (prod.size() != 0) {
				for (Object product : prod) {
					System.out.println(product);
				}
			} else {
				System.out.println("No Product found Beetween this range ? ");
			}
		} catch (NoResultException e) {
			System.out.println();
		} catch (Exception e) {
			System.err.println("No Product found Beetween this range ?  ");
		}
		sc.close();
	}


}
