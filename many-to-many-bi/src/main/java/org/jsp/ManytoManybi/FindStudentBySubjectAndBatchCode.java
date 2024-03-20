package org.jsp.ManytoManybi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentBySubjectAndBatchCode {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Batch Code ? ");
		String code=sc.next();
		System.out.println("Enter the subject Name ?");
		String sub=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select b.students from Batch b where b.batch_code=?1 and b.subject=?2");
		q.setParameter(1, code);
		q.setParameter(2, sub);
		try {
			List<Batch> b= q.getResultList();
			if(b.size() != 0) {
				for(Object batch:b) {
					System.out.println(batch);
				}
			}else {
				System.err.println("Invalid Batch Code or Subject name ");
			}
			
		}catch (NoResultException e) {
			System.err.println("Invalid Batch Code or Subject name ");
		}sc.close();
	}


}
