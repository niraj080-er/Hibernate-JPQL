package org.jsp.ManytoManybi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByName {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Student Name");
		String name=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q = manager.createQuery("select s from Student s where s.name=?1");
		q.setParameter(1, name);
		try {
			Student b=(Student) q.getSingleResult();
			System.out.println(b);
		}catch (NoResultException e) {
			System.err.println("Invalid Name");
		}
		sc.close();
		
	}

}
