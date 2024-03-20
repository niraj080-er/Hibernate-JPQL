package org.jsp.OneToManyUni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Product Id ? ");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select p from Product p where p.id=?1");
		q.setParameter(1, id);
		try {
			Product prod = (Product) q.getSingleResult();
			System.out.println(prod);
		} catch (NoResultException e) {
			System.out.println();
		}catch (Exception e) {
			System.err.println("Invalid Id ? ");
		}sc.close();
	}

}
