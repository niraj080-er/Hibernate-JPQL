package org.jsp.OneToOne;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindPersonByID {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Person Id to find the Person Details");
		int id=sc.nextInt();
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Person p=manager.find(Person.class, id);
		if(p!=null) {
			System.out.println(p);
		}else {
			System.err.println("Invalid Id");
		}
		sc.close();
	}

}
