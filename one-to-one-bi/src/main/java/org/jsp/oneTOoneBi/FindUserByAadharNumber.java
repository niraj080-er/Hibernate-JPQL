package org.jsp.oneTOoneBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Aadhar number to fetch the Details");
		long aadharNumber=sc.nextLong();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select c.user from AadharCard c where c.number=?1");
		q.setParameter(1, aadharNumber);
		try {
			User u=(User) q.getSingleResult();
			System.out.println(u);
		}catch(NoResultException e) {
			System.out.println("Invalid Aadhar Number");
		}sc.close();
	}

}
