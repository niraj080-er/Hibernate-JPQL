package org.jsp.ManyToOneUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestionDataByPostedAttribute {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Question Attribute ? ");
		String ques=sc.nextLine();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select q from QuestionData q where q.postedBy=?1");
		q.setParameter(1, ques);
		try {
			List <QuestionData> qu= q.getResultList();
			if(qu.size() != 0) {
				for(Object data:qu) {
					System.out.println(data);
				}
			}else {
				System.err.println("Invalid PostedAttribute ? ");
			}
			
		}catch (NoResultException e) {
			System.err.println("Invalid PostedAttribute ? ");
		}sc.close();
	}

}
