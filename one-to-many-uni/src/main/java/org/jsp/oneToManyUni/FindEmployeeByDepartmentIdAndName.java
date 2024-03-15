package org.jsp.oneToManyUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeeByDepartmentIdAndName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter department id to find all Employee");
		int id = sc.nextInt();
		System.out.println("Enter the Name find employee Details");
		String name=sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select d.emps from Department d where d.id=?1 and d.deptName=?2");
		q.setParameter(1, id);
		q.setParameter(2, name);
		List<Employee> emp = q.getResultList();
		if (emp.size() > 0) {
			for (Employee e : emp) {
				System.out.println(e);
			}
		} else {
			 System.out.println("There are no employees in department " + id + " with name " + name);
		}
		sc.close();
		
	}
}


// "select e from Employee e JOIN e.Department d where d.id = ?1 and e.employeeName = ?"