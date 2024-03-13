package org.jsp.OneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPhoneNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Phone number to fetch the Person Details ");
		Long phone=sc.nextLong();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select p from Person p where p.phone=?1");
		q.setParameter(1, phone);
		try {
			Person p=(Person) q.getSingleResult();
			System.out.println(p);
		}catch(NoResultException e) {
			System.err.println("Invalid phone number");
		}
		sc.close();
	}

}
