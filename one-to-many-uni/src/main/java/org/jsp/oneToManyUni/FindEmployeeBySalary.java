package org.jsp.oneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindEmployeeBySalary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Salary ");
		double sal = sc.nextDouble();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select e from Employee e where e.salary=?1");
		q.setParameter(1, sal);
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

