package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Sauvegarde;
import util.Context;

public class DAOSauvegarde implements IDAO<Sauvegarde>{

	@Override
	public Sauvegarde findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		Sauvegarde sauvegarde=em.find(Sauvegarde.class, id);

		em.close();
		return sauvegarde;
	}

	@Override
	public List<Sauvegarde> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT s from Sauvegarde s",Sauvegarde.class);
		List<Sauvegarde> sauvegardes=myQuery.getResultList();
		em.close();
		return sauvegardes;
	}

	@Override
	public Sauvegarde save(Sauvegarde sauvegarde) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		sauvegarde=em.merge(sauvegarde);
		em.getTransaction().commit();
		em.close();
		return sauvegarde;
	}

	@Override
	public void delete(Sauvegarde sauvegarde) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		sauvegarde=em.merge(sauvegarde);
		em.remove(sauvegarde);
		em.getTransaction().commit();
		em.close();
	}


}
