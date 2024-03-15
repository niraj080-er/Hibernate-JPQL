package org.jsp.oneTOoneBi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharNumberAndDOB {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Aadhar Number ");
		long uNumber=sc.nextLong();
		System.out.println("Enter the DOB (yyyy-mm-dd)");
		LocalDate dob=LocalDate.parse(sc.next());
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select c.user from AadharCard c where c.number=?1 and c.dob=?2");
		q.setParameter(1, uNumber);
		q.setParameter(2, dob);
		try {
			User u= (User) q.getSingleResult();
			System.out.println(u);
		}catch (Exception e) {
			System.err.println("Invalid Aadhar number or DOB ");
		}sc.close();
				 
	}

}
