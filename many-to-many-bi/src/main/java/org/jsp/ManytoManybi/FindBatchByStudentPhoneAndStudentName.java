package org.jsp.ManytoManybi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchByStudentPhoneAndStudentName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Student Phone Number ? ");
		long number = sc.nextLong();
		System.out.println("Enter the Student Name ? ");
		String name = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select s.batchs from Student s where s.phone=?1 and s.name=?2");
		q.setParameter(1, number);
		q.setParameter(2, name);
		try {
			List<Batch> b = q.getResultList();
			if (b.size() != 0) {
				for (Object batch : b) {
					System.out.println(batch);
				}
			} else {
				System.err.println("Invalid Student phone number or Name");
			}

		} catch (NoResultException e) {
			System.err.println("Invalid Student phone number or Name");
		}
		sc.close();
	}

}
