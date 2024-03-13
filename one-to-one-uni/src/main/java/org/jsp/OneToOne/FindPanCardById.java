package org.jsp.OneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Id to fetch the PanCard Details");
		int id=sc.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select c from PanCard c where c.id=?1");
		q.setParameter(1, id);
		try {
			PanCard card=(PanCard) q.getSingleResult();
			System.out.println(card);
		}catch(NoResultException e) {
			System.err.println("Invalid ID");
		}
		sc.close();
	}

}
