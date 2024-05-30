package Hibernate_Second;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Hql_Dynamic_Query {

	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the price : ");
		int price = sc.nextInt();
		
		//Based on position
		Query q = manager.createQuery("select b from Book b where b.price=?1");
		q.setParameter(1, price);
		
		//Based on Name
		// Query q1 = manager.createQuery("select b from Book b where b.price=:n ");
		// q1.setParameter("n", price);
		
		List<Book> books = q.getResultList();
		for(Book b : books)
		{
			System.out.println(b.getBname()+" "+b.getPrice()+" "+b.getAuthor());
		}

	}

}
