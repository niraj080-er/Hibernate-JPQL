package org.jsp.oneToManyUni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveEMployeeAndDepartment {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		Department d=new Department();
		d.setDeptName("Development");
		d.setLocation("Bangalore");
		
		Employee e1= new Employee();
		e1.setEmployeeName("Niraj Kumar");
		e1.setDesg("SDE");
		e1.setSalary(50000);
		
		Employee e2= new Employee();
		e2.setEmployeeName("Ajay Kumar");
		e2.setDesg("SDE");
		e2.setSalary(50000);
		
		Employee e3= new Employee();
		e3.setEmployeeName("Kumar");
		e3.setDesg("SDE");
		e3.setSalary(50000);
		
		List<Employee> emps=new ArrayList<Employee>();
		emps.add(e1);emps.add(e2);emps.add(e3);
		d.setEmps(emps);
		manager.persist(d);
		transaction.begin();
		transaction.commit();
	}

}
