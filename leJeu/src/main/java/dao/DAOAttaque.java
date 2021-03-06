package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Attaque;
import metier.User;
import util.Context;

public class DAOAttaque implements IDAO<Attaque>{

	@Override
	public Attaque findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		Attaque u=em.find(Attaque.class, id);

		em.close();
		return u;
	}

	@Override
	public List<Attaque> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		Query myQuery = em.createQuery("SELECT a from Attaque a",Attaque.class);
		List<Attaque> attaques=myQuery.getResultList();
		em.close();
		return attaques;
	}

	@Override
	public Attaque save(Attaque attaque) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		attaque=em.merge(attaque);
		em.getTransaction().commit();
		em.close();
		return attaque;
	}

	@Override
	public void delete(Attaque attaque) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		attaque=em.merge(attaque);
		em.remove(attaque);
		em.getTransaction().commit();
		em.close();
	}

}
