package org.jsp.OneToOne;

import java.time.LocalDate;
import javax.persistence.*;


public class SavePersonAndPanCard {
	public static void main(String[] args) {
		EntityManagerFactory factory=
				Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		Person p=new Person();
		p.setName("Kumar");
		p.setPhone(9507480400L);
		
		PanCard card= new PanCard();
		card.setNumber("INCPK9035G");
		card.setDob(LocalDate.parse("2001-04-12"));
		card.setPinCode(841507);
		
		p.setCard(card); // Assigning the PanCard to the Person
		manager.persist(card);
		manager.persist(p);
		transaction.begin();
		transaction.commit();
	}

}
