package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import app.books.models.Book;

public class HibernateUtils {

	private static SessionFactory factory = null;

	public static SessionFactory getSessionFactory() {
		if (factory != null) {
			return factory;
		}
		try {
			factory = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory;
	}

}
