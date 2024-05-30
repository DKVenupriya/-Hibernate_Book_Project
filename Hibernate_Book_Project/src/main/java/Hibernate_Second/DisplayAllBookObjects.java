package Hibernate_Second;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DisplayAllBookObjects {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select b from Book b");
		
		List<Book>  books = q.getResultList();
		
		for(Book b : books)
		{
			System.out.println(b.getId()+" "+b.getBname()+" "+b.getPrice()+" "+b.getAuthor());
	
		}
	
	} 
	
	

}
