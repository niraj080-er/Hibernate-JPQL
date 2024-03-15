package org.jsp.oneTOoneBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharById {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Id to Fetch the Adhar Details ");
		int id=sc.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select c from AadharCard c where c.id=?1");
		q.setParameter(1, id);
		try {
			AadharCard card =(AadharCard) q.getSingleResult();
			System.out.println(card);

		}catch (NoResultException e) {
			System.err.println("Invalid Id");		
		}
		sc.close();
	}

}
