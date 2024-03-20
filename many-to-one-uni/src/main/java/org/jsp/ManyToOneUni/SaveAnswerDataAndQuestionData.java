package org.jsp.ManyToOneUni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveAnswerDataAndQuestionData {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		QuestionData data=new QuestionData();
		data.setPostedBy("Satish Sir");
		data.setQuestion("What is Hibernate ? ");
		
		AnswerData a1=new AnswerData();
		a1.setAnsweredBy("Niraj Kumar");
		a1.setAnswer("Hibernate is an Open source framework ");
		a1.setQuestion(data);
		
		AnswerData a2=new AnswerData();
		a2.setAnsweredBy("Ajay Kumar");
		a2.setAnswer("Hibernate is a NON-Invasive framework ");
		a2.setQuestion(data);
		
		AnswerData a3=new AnswerData();
		a3.setAnsweredBy("Kumar");
		a3.setAnswer("Hibernate is an ORM TOOL ");
		a3.setQuestion(data);
		
		manager.persist(a1);
		manager.persist(a2);
		manager.persist(a3);
		
		transaction.begin();
		transaction.commit();
		
	}

}
