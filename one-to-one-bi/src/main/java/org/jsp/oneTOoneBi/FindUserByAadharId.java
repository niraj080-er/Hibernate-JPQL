package org.jsp.oneTOoneBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharId {
	public static void main(String[] args) {
		 Scanner sc= new Scanner(System.in);
		 System.out.println("Enter the AadharCard Id Number to Fetch the User Details");
		 int id=sc.nextInt();
		 EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		 EntityManager manager=factory.createEntityManager();
		 Query q=manager.createQuery("select c.user from AadharCard c where c.id=?1");
		 q.setParameter(1, id);
		 try {
			 User u=(User) q.getSingleResult();
			 System.out.println(u);
		 }catch (NoResultException e) {
			System.out.println("Invalid Id");
		}sc.close();
	}

}
