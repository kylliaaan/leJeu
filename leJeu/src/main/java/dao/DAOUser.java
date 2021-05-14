package dao;

import java.util.List;

import javax.persistence.EntityManager;

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
		return null;
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


}
