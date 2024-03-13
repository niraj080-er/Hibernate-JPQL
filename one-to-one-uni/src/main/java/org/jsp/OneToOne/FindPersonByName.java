package org.jsp.OneToOne;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Person Name to find the Person Details");
        String name = sc.nextLine();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
        EntityManager manager = factory.createEntityManager();
        Query q = manager.createQuery("select p from Person p where p.name=?1");
        q.setParameter(1, name);
        try {
     
            List<Person> persons = (List<Person>) q.getResultList();
            if (persons != null) {
                for (Person person : persons) {
                    System.out.println(person);
                }
            } else {
                System.err.println("No person found with the given name.");
            }
        } catch (NoResultException e) {
            System.err.println("Invalid Name ");
        }
        sc.close();
    }
}
