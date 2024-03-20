package org.jsp.ManytoManybi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchBySubject {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Subject to Find the Batch ");
		String batch=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select b from Batch b where b.subject=?1");
		q.setParameter(1, batch);
		try {
			List<Batch> b=q.getResultList();
			for(Object bat:b) {
				System.out.println(bat);
			}
		}catch (NoResultException e) {
			System.err.println("Invalid Subject name");
		}
		sc.close();

	}


}
