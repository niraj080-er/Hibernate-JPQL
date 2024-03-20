package org.jsp.ManyToOneUni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataByAnswerAttribute {
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		System.out.println("Enter an Answer Attribute ? ");
		String ans=sc.nextLine();
		EntityManagerFactory factory=
		Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select a from AnswerData a where a.answer=?1");
		q.setParameter(1, ans);
		try {
			AnswerData data = (AnswerData) q.getSingleResult();
			System.out.println(data);
		}catch (NoResultException e) {
			System.out.println("Invalid an AnswerData ? ");
		}sc.close();
	}

}
