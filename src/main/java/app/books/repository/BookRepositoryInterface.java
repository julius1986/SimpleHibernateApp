package app.books.repository;

import java.util.List;
/**
 * Custom methods repositories*/
public interface BookRepositoryInterface<A, T> {
	public boolean save(T obj);
	public List<T> findAll();
	public T getById(A id);
	public boolean removeById(A id);
	public void removeByInstance(T object);

}
