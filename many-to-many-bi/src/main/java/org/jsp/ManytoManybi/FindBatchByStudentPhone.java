package org.jsp.ManytoManybi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;
public class FindBatchByStudentPhone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Student Phone Number ? ");
		long number=sc.nextLong();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createQuery("select s.batchs from Student s where s.phone=?1");
		q.setParameter(1, number);
		try {
			List<Batch> b= q.getResultList();
			if(b.size() != 0) {
				for(Object batch:b) {
					System.out.println(batch);
				}
			}else {
				System.err.println("Invalid Student phone number ");
			}
			
		}catch (NoResultException e) {
			System.err.println("Invalid Student phone number ");
		}sc.close();
	}


}
