package org.jsp.OneToOne;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Testcfg {
	public static void main(String[] args) {
		EntityManagerFactory factory=
				Persistence.createEntityManagerFactory("development");
		System.out.println(factory);
	}

}
