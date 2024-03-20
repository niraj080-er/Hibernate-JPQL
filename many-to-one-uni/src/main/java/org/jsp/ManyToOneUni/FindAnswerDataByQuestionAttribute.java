package org.jsp.ManyToOneUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataByQuestionAttribute {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Question Attribute ? ");
		String ques=sc.nextLine();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select a from AnswerData a where a.question.question=?1");
		q.setParameter(1, ques);
		try {
			List<AnswerData> data= q.getResultList();
			if(data.size() != 0) {
				for(Object ans:data) {
					System.out.println(ans);
				}
			}else {
				System.err.println("Invalid Question Data");
			}
		}catch (NoResultException e) {
			System.err.println("Invalid Question Id ? ");
		}sc.close();
		
	}

}
