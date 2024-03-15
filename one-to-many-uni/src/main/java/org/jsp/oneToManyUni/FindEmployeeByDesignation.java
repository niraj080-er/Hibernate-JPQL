package org.jsp.oneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindEmployeeByDesignation {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee Disgnation ");
			String disg = sc.next();
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
			EntityManager manager = factory.createEntityManager();
			Query q = manager.createQuery("select e from Employee e where e.desg=?1");
			q.setParameter(1, disg);
			List<Employee> emp = q.getResultList();
			if (emp.size() > 0) {
				for (Employee e : emp) {
					System.out.println(e);
				}
			} else {
				System.err.println("no employee found by this name");
			}
		}

	}