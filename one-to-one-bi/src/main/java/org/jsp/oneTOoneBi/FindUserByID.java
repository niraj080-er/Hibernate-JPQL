package org.jsp.oneTOoneBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByID {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the User ID to find the User Details");
		int id=sc.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manger=factory.createEntityManager();
		Query q=manger.createQuery("select u from User u where u.id=?1");
		q.setParameter(1, id);
		try {
			User u=(User) q.getSingleResult();
			System.out.println(u);
		}catch(NoResultException e) {
			System.err.println("Invalid id ");
		}
		sc.close();
	}

}
