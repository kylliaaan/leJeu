package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOAttaque;
import dao.DAOPersonnage;
import dao.DAOUser;

public class Context {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("lejeu");
	private DAOUser daoUser = new DAOUser();
	private DAOPersonnage daoPerso = new DAOPersonnage();
	private DAOAttaque daoAttaque = new DAOAttaque();
	
	private static Context _instance=null; 
	
	private Context() {}
	
	
	public static Context get_instance() {
		if(_instance==null) {_instance=new Context();}
//		else System.out.println("old instance");
		return _instance;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public DAOUser getDaoUser() {
		return daoUser;
	}

	public void setDaoUser(DAOUser daoUser) {
		this.daoUser = daoUser;
	}


	public DAOPersonnage getDaoPerso() {
		return daoPerso;
	}


	public void setDaoPerso(DAOPersonnage daoPerso) {
		this.daoPerso = daoPerso;
	}


	public DAOAttaque getDaoAttaque() {
		return daoAttaque;
	}


	public void setDaoAttaque(DAOAttaque daoAttaque) {
		this.daoAttaque = daoAttaque;
	}
	
	
	
}
