package org.jsp.OneToOne;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByNumberAndDOB {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the PanCard Number");
		String number=sc.next();
		System.out.println("Enter the DOB (yyyy-mm-dd)");
		LocalDate dob = LocalDate.parse(sc.next());
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q= manager.createQuery("select c from PanCard c where c.number=?1 and c.dob=?2");
		q.setParameter(1, number);
		q.setParameter(2, dob);
		try {
			PanCard card=(PanCard) q.getSingleResult();
			System.out.println(card);
		}catch(NoResultException e) {
			System.err.println("Invalid PanCard Number or Date of Birth ");
		}
		sc.close();
				
	}

}
