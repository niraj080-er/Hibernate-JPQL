package org.jsp.oneTOoneBi;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUserAndAadharCard {
	public static void main(String[] args) {
		User user=new User();
		user.setName("Niraj kumar");
		user.setPhone(6280458043L);
		
		AadharCard card=new AadharCard();
		card.setNumber(123412341234L);
		card.setDob(LocalDate.parse("2001-04-12"));
		card.setCity("Siwan");
		
		user.setCard(card);
		card.setUser(user);
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		manager.persist(user);
		transaction.begin();
		transaction.commit();
	}

}


