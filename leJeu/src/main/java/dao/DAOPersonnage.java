package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Attaque;
import metier.Personnage;
import util.Context;

public class DAOPersonnage implements IDAO<Personnage>{

	@Override
	public Personnage findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		Personnage perso=em.find(Personnage.class, id);

		em.close();
		return perso;
	}

	@Override
	public List<Personnage> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT p from Personnage p",Personnage.class);
		List<Personnage> personnages=myQuery.getResultList();
		em.close();
		return personnages;
	}

	@Override
	public Personnage save(Personnage perso) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		perso=em.merge(perso);
		em.getTransaction().commit();
		em.close();
		return perso;
	}

	@Override
	public void delete(Personnage perso) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		perso=em.merge(perso);
		em.remove(perso);
		em.getTransaction().commit();
		em.close();
	}


}
