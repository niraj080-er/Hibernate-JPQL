package org.jsp.ManytoManybi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentPercIsBW35And59 {
	public static void main(String[] args) {
		double minPer = 35.0;
		double maxPerc= 59.9;
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q = manager.createQuery("select s from Student s where s.perc > ?1 and s.perc < ?2");
		q.setParameter(1, minPer);
		q.setParameter(2, maxPerc);
		try {
            List<Student> students = q.getResultList();
            if (students.isEmpty()) {
                System.err.println("No students found with percentage ");
            } else {
                System.out.println("Students with percentage");
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        } catch (NoResultException e) {
            System.err.println("No students found with percentage ");
        }		
	}
}
