package org.jsp.OneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardDetailsByNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the PanCard Number to Diplay the Details ");
		String number=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select c from PanCard c where c.number=?1");
		q.setParameter(1, number);
		try {
			 PanCard p=(PanCard) q.getSingleResult();
			 System.out.println(p);
			
		}catch(NoResultException e) {
			System.out.println("Invalid PanCard  Number");
		}
		sc.close();
		
	}

}
