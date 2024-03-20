package org.jsp.ManytoManybi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Batch Id ");
		int id=sc.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select b from Batch b where b.id=?1");
		q.setParameter(1, id);
		try {
			Batch b=(Batch) q.getSingleResult();
			System.out.println(b);
		}catch (NoResultException e) {
			System.err.println("Invalid Id");
		}
		sc.close();
		
	}

}
