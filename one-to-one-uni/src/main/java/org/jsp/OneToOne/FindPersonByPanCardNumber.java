package org.jsp.OneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPanCardNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the PanCard Number to fetch the Person Details ");
		String number=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q= manager.createQuery("select p from Person p where p.card.number=?1");
		q.setParameter(1, number);
		try {
			Person p=(Person) q.getSingleResult();
			System.out.println(p);
		}catch(NoResultException e) {
			System.err.println("Invalid PanCard Number");
		}
		sc.close();
	}

}
