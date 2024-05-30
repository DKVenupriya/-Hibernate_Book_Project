package Hibernate_Second;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertingBookObjects {

	public static void main(String[] args) {


		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of times you want to enter book data : ");
		int ch = sc.nextInt();
		for(int i=1 ; i <= ch ; i++)
		{
		System.out.println("Enter the name : ");
		String name = sc.next();
		System.out.print("Enter the Book price : ");
		int price = sc.nextInt();
		System.out.println("Enter the Author of Book : ");
		String author = sc.next();
		
		
		
		Book book = new Book();
		
		book.setBname(name);
		book.setPrice(price);
		book.setAuthor(author);
		
		transaction.begin();
		
		manager.persist(book);
		
		transaction.commit();
	}
	}
	

}
