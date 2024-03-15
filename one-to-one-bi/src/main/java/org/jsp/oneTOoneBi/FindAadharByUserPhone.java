package org.jsp.oneTOoneBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserPhone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Phone number to fetch the Details");
		long number=sc.nextLong();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select u.card from User u where u.phone=?1");
		q.setParameter(1, number);
		try {
			AadharCard card=(AadharCard) q.getSingleResult();
			System.out.println(card);
		}catch(NoResultException e) {
			System.out.println("Invalid Phone Number");
		}sc.close();
	}

}
