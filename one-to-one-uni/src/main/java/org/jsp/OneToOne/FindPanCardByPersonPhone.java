package org.jsp.OneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByPersonPhone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Person Phone Number to fetch the PanCard Details ");
		Long number=sc.nextLong();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select p.card from Person p where p.phone=?1");
		q.setParameter(1, number);
		try {
			PanCard card=(PanCard) q.getSingleResult();
			System.out.println(card);
		}catch(NoResultException e) {
			System.err.println("Invalid PanCardNumber");
		}
		sc.close();
	}

}
