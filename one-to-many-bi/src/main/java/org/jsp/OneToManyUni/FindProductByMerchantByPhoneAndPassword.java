package org.jsp.OneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantByPhoneAndPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Merchant Phone Number ? ");
		long number = sc.nextLong();
		System.out.println("Enter the Merchant Passwprd ? ");
		String pass = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select m.products from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1, number);
		q.setParameter(2, pass);
		try {
			List<Product> prod = q.getResultList();
			if (prod.size() != 0) {
				for (Object product : prod) {
					System.out.println(product);
				}
			} else {
				System.err.println("Invalid Merchant Phone Number or Password ");
			}
		} catch (NoResultException e) {
			System.err.println("Invalid Merchant Phone Number or Password ");
		}
		sc.close();
	}

}
