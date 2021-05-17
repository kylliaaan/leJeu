package metier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sauvegardes")
public class Sauvegarde {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_sauvegarde")
	private int id;
	private int nbVictoire; 
	private boolean statut; //A quoi ça sert ?
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name="userID",nullable=false)
	private User user;
	
	@OneToOne
	@JoinColumn(name="ID_classe_du_perso")
	private Personnage perso;
	
	@OneToMany
	@JoinTable(name="sauvegardes_d_attaques",
	joinColumns = @JoinColumn(name="idSauvegarde"),
	inverseJoinColumns = @JoinColumn(name="idAttaque"))
	List<Attaque> attaques = new ArrayList();

	@OneToMany
	@JoinTable(name="sauvegardes_d_objets",
	joinColumns = @JoinColumn(name="idSauvegarde"),
	inverseJoinColumns = @JoinColumn(name="idObjet"))
	List<Objet> objets = new ArrayList();

	public Sauvegarde() {}

	public Sauvegarde(User user, Personnage perso, List<Attaque> attaques, List<Objet> objets) {
		this.date= LocalDateTime.now();
		this.perso= perso;
		this.user = user;
		this.attaques = attaques;
		this.objets = objets;
	}

	public Sauvegarde(int nbVictoire, boolean statut, LocalDateTime date, User user, List<Attaque> attaques, List<Objet> objets) {
		this.nbVictoire = nbVictoire;
		this.statut = statut;
		this.date = date;
		this.user = user;
		this.attaques = attaques;
		this.objets = objets;
	}

	public int getNbVictoire() {
		return nbVictoire;
	}

	public void setNbVictoire(int nbVictoire) {
		this.nbVictoire = nbVictoire;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Attaque> getAttaques() {
		return attaques;
	}

	public void setAttaques(List<Attaque> attaques) {
		this.attaques = attaques;
	}

	public List<Objet> getObjets() {
		return objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Sauvegarde [id=" + id + ", nbVictoire=" + nbVictoire + ", statut=" + statut +
				", attaques=" + attaques + ", objets=" + objets + "]";
	}
	
}
