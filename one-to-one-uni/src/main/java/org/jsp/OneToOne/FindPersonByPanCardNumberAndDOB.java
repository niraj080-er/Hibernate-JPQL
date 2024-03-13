package org.jsp.OneToOne;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPanCardNumberAndDOB {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the PanCard Number");
		String number=sc.next();
		System.out.println("Enter the DOB (yyyy-mm-dd)");
		LocalDate dob = LocalDate.parse(sc.next());
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select p from Person p where p.card.number=?1 and p.card.dob=?2");
		q.setParameter(1, number);
		q.setParameter(2, dob);
		try {
			Person p=(Person) q.getSingleResult();
			System.out.println(p);
		}catch(NoResultException e) {
			System.out.println("Invalid PanCard Number or DOB ");
		}
		
	}

}
