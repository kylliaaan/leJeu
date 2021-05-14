package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Objet;
import metier.Personnage;
import metier.Objet;
import util.Context;

public class DAOObjet implements IDAO<Objet>{

	@Override
	public Objet findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		Objet objet=em.find(Objet.class, id);

		em.close();
		return objet;
	}

	@Override
	public List<Objet> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT o from Objet o",Objet.class);
		List<Objet> objets=myQuery.getResultList();
		em.close();
		return objets;
	}

	@Override
	public Objet save(Objet objet) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Objet objet) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.remove(objet);
		em.getTransaction().commit();
		em.close();
	}
	
}
