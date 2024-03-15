package org.jsp.oneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class FindEmployeeByDepartmentIdAndLocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter department id to find all Employee");
		int id = sc.nextInt();
		System.out.println("Enter the Department Location to find all employee Details");
		String loc=sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select d.emps from Department d where d.id=?1 and d.location=?2");
		q.setParameter(1, id);
		q.setParameter(2, loc);
		List<Employee> emp = q.getResultList();
		if (emp.size() > 0) {
			for (Employee e : emp) {
				System.out.println(e);
			}
		} else {
			System.out.println("there is no employee in department " + id);
		}
		sc.close();
	}

}
