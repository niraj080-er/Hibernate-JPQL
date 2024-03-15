package org.jsp.oneTOoneBi;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByName {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the User Name to Find the Details");
		String uName=sc.nextLine();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q= manager.createQuery("select u from User u where u.name=?1");
		q.setParameter(1, uName);
		try {
			List<User> u =(List<User>) q.getResultList();
			System.out.println(u);
		}catch(NoResultException e) {
			System.out.println("Invallid User Name");
		}
		sc.close();
	}
	

}
