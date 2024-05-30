package Hibernate_Second;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateAuthorByBName {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		Query q = manager.createQuery("update Book b set b.author = ?1 , b.price = ?2 where b.bname = ?3");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the author : ");
		String author = sc.next();
		
		System.out.println("Enter the price : ");
		int price = sc.nextInt();
		
		System.out.println("Enter the book name : ");
		String bname = sc.next();
		
		q.setParameter(1, author);
		q.setParameter(2, price);
		q.setParameter(3, bname);
		
		transaction.begin();
		
		q.executeUpdate();
		
		transaction.commit();
		

	}

}
