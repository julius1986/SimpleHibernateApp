package app.books.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import app.books.models.Book;
import utils.HibernateUtils;
/**
 * Implementation of BooksRepositoryInterface*/
public class BookRepositoryImplement implements BookRepositoryInterface<Long, Book> {

	SessionFactory sessionFactory;

	public boolean save(Book book) {
		sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx1 = session.beginTransaction();
		session.save(book);
		tx1.commit();
		session.close();
		return true;
	}

	public List<Book> findAll() {
		List<Book> listBooks = null;
		sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx1 = session.beginTransaction();
		// Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();
		// Create CriteriaQuery
		CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
		criteria.from(Book.class);
		listBooks = session.createQuery(criteria).getResultList();
		tx1.commit();
		session.close();
		return listBooks;
	}

	public Book getById(Long id) {
		Book book = null;
		sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx1 = session.beginTransaction();
		book = session.find(Book.class, id);
		tx1.commit();
		session.close();
		return book;
	}

	public boolean removeById(Long id) {
		boolean result = false;
		Book book = null;
		sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx1 = session.beginTransaction();
		book = session.find(Book.class, id);
		if (book != null) {
			session.remove(book);
			result = true;
		}
		tx1.commit();
		session.close();
		return result;
	}

	public void removeByInstance(Book books) {
		boolean result = false;
		sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx1 = session.beginTransaction();
		session.remove(books);
		tx1.commit();
		session.close();
	}

}
