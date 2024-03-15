package org.jsp.oneToManyUni;

import java.util.Scanner;

import javax.persistence.*;

public class FindDepartmentByLocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Location ");
		String deptloc = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select d from Department d where d.location=?1");
		q.setParameter(1, deptloc);
		try {
			Department dept = (Department) q.getSingleResult();
			System.out.println(dept);
		} catch (NoResultException e) {
			System.err.println("such department Location is not Exites");
		}
			sc.close();						
	}

}