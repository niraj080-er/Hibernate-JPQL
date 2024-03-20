package org.jsp.ManytoManybi;

import java.util.List;

import javax.persistence.*;

public class FindStudentPercGreaterthan35 {
	public static void main(String[] args) {
		double minPer = 35.0;
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q = manager.createQuery("select s from Student s where s.perc > ?1");
		q.setParameter(1, minPer);
		try {
            List<Student> students = q.getResultList();
            if (students.isEmpty()) {
                System.out.println("No students found with percentage ");
            } else {
                System.out.println("Students with percentage greater than ");
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        } catch (NoResultException e) {
            System.err.println("No students found with percentage greater than ");
        }
//		sc.close();
		
	}

}
