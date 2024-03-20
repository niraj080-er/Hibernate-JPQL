package org.jsp.ManyToOneUni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Answer Id ? ");
		int id=sc.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select a from AnswerData a where a.id=?1");
		q.setParameter(1, id);
		try {
			Object data = q.getSingleResult();
			System.out.println(data);
		}catch (NoResultException e) {
			System.err.println("Invalid Answer Id ? ");
		}sc.close();
		
	}

}
