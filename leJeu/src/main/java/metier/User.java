package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String login;
	private String password;
	
	@OneToMany(mappedBy="user",cascade = {CascadeType.MERGE,CascadeType.REMOVE})
	private List<Sauvegarde> sauvegardes = new ArrayList();
	
	public User() {}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	
	public User(String login, String password, List<Sauvegarde> sauvegardes) {
		super();
		this.login = login;
		this.password = password;
		this.sauvegardes = sauvegardes;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Sauvegarde> getSauvegardes() {
		return sauvegardes;
	}

	public void setSauvegardes(List<Sauvegarde> sauvegardes) {
		this.sauvegardes = sauvegardes;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", sauvegardes=" + sauvegardes + "]";
	}
	
}
