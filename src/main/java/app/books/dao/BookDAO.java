package app.books.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import app.books.models.Book;
import utils.HibernateUtils;
/**
 * Testing DAO
 * */
public class BookDAO {

	SessionFactory sessionFactory;
	/*Just somple example for add Book*/
	public boolean addNewBook(Book book) {
		sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx1 = session.beginTransaction();
		session.save(book);
		tx1.commit();
		session.close();
		return true;
	}

}
