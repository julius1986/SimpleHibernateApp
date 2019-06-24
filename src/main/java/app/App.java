package app;

import app.books.dao.BookDAO;
import app.books.repository.BookRepositoryImplement;
import app.books.models.Book;

public class App {
	public static void main(String[] args) {
		BookDAO bookDAO = new BookDAO();
		bookDAO.addNewBook(new Book("Star Wars"));
		bookDAO.addNewBook(new Book("Nemo"));
		bookDAO.addNewBook(new Book("Book of jungle"));
		Book book4 = new Book("Rambo");
		bookDAO.addNewBook(book4);
		BookRepositoryImplement br = new BookRepositoryImplement();

		System.out.println("------------");
		System.out.println("we find: " + br.getById(3L).getTitle());
		System.out.println("------------");
		System.out.println("deleting: " + br.getById(3L).getTitle());
		br.removeById(3L);
		System.out.println("------------");
		
		System.out.println("deleting: " + book4.getTitle());
		br.removeByInstance(book4);
		System.out.println("------------");
		
		System.out.println("***All books***");
		for (Book book : br.findAll()) {
			System.out.println(book.getTitle());
		}

	}

}
