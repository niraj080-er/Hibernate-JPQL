package org.jsp.oneToManyUni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindDepartmentByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee Name ");
		String name = sc.nextLine();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select d from Department d where d.deptName=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, name);
		try {
			Department dept = (Department) q.getSingleResult();
			System.out.println(dept);
		} catch (NoResultException e) {
			System.err.println("such name is not exites");
		}
		sc.close();

	}
}
