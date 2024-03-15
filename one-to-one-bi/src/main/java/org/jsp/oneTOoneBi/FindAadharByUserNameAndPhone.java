package org.jsp.oneTOoneBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserNameAndPhone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the User Name to Find the Details");
		String uName=sc.nextLine();
		System.out.println("Enter the Phone number to fetch the Details");
		long number=sc.nextLong();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select u.card from User u where u.name=?1 and u.phone=?2");
		q.setParameter(1, uName);
		q.setParameter(2, number);
		try {
			List <AadharCard> card=(List<AadharCard>) q.getResultList();
			System.out.println(card);
		}catch(NoResultException e) {
			System.out.println("Invalid Phone Number");
		}sc.close();
	}

}
