package dao;

import java.util.List;

public interface IDAO<T> {
	
	public T findById(int id);
	public List<T> findAll();
	public T save(T entity);
	public void delete(T entity);
	
}