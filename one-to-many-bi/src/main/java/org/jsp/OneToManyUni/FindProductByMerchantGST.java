package org.jsp.OneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantGST {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Merchant GST_Number ");
		String name=sc.nextLine();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select m.products from Merchant m where m.gst_number=?1");
		q.setParameter(1, name);
		try {
			List<Product> prod = q.getResultList();
			if (prod.size() != 0) {
				for (Object product : prod) {
					System.out.println(product);
				}
			} else {
				System.err.println("Invalid Merchant GST Number ");
			}
		} catch (NoResultException e) {
			System.err.println("Invalid Merchant GST Number ");
		}
		sc.close();
	}

}

