package org.jsp.oneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindEmployeeByDeptId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter department id to find all Employee");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select d.emps from Department d where d.id=?1");
		q.setParameter(1, id);
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