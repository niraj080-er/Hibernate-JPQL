package org.jsp.oneToManyUni;

import java.util.Scanner;

import javax.persistence.*;

public class FindEmployeeById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id ");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager(); 
		Query q = manager.createQuery("select e from Employee e where e.id=?1");
		q.setParameter(1, id);
		try {
			Employee emp = (Employee) q.getSingleResult();
			System.out.println(emp);
		} catch (NoResultException e) {
			System.err.println("such department id is not Exites");
		}

	}

}