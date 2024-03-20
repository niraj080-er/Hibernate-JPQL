package org.jsp.ManytoManybi;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveBatchAndStuden {

	public static void main(String[] args) {

		Student s1 = new Student();
		s1.setName("raja");
		s1.setPhone(1234);
		s1.setPerc(75.45);

		Student s2 = new Student();
		s2.setName("niraj");
		s2.setPhone(123456);
		s2.setPerc(79.45);

		Student s3 = new Student();
		s3.setName("rajesh");
		s3.setPhone(123478);
		s3.setPerc(85.45);

		Batch b1 = new Batch();
		b1.setBatch_code("j123");
		b1.setSubject("java");
		b1.setTrainner("keshava sir");

		Batch b2 = new Batch();
		b2.setBatch_code("pr123");
		b2.setSubject("programing");
		b2.setTrainner("Dharshan sir");

		Batch b3 = new Batch();
		b3.setBatch_code("sql123");
		b3.setSubject("SQL");
		b3.setTrainner("Sweetha");

		Batch b4 = new Batch();
		b4.setBatch_code("h123");
		b4.setSubject("j2ee");
		b4.setTrainner("Shathish sir");

		b1.setStudents(Arrays.asList(s1, s2, s3));
		b2.setStudents(Arrays.asList(s1, s2, s3));
		b3.setStudents(Arrays.asList(s1, s3));
		b4.setStudents(Arrays.asList(s2, s3));

		s1.setBatchs(Arrays.asList(b1, b2, b3));
		s1.setBatchs(Arrays.asList(b1, b2, b4));
		s1.setBatchs(Arrays.asList(b1, b2, b3, b4));

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		manager.persist(b4);

		transaction.begin();
		transaction.commit();

	}

}