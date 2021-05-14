package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.User;
import util.Context;

public class DAOUser implements IDAO<User>{

	@Override
	public User findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		User u=em.find(User.class, id);

		em.close();
		return u;
	}

	@Override
	public List<User> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT u from User u",User.class);
		List<User> users=myQuery.getResultList();
		em.close();
		return users;
	}

	@Override
	public User save(User user) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		user=em.merge(user);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public void delete(User user) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		user=em.merge(user);
		em.remove(user);
		em.getTransaction().commit();
		em.close();
	}

	public User checkConnect(String login, String password) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT u from User u WHERE u.login = :login and u.password= :password",User.class);
//		myQuery.setParameter("login", login);
//		myQuery.setParameter("password", password);
//		User user= (User) myQuery.getSingleResult();
//		em.close();
//		return user;
		return null;
	}


}
