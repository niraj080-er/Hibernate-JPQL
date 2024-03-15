package org.jsp.oneTOoneBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserID {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Id number to fetch the Details");
			int id=sc.nextInt();
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
			EntityManager manager=factory.createEntityManager();
			Query q=manager.createQuery("select u.card from User u where u.id=?1");
			q.setParameter(1, id);
			try {
				AadharCard card=(AadharCard) q.getSingleResult();
				System.out.println(card);
			}catch(NoResultException e) {
				System.out.println("Invalid Id Number");
			}sc.close();
		}
	}