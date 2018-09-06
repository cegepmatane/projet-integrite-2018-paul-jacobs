package modele;

public class Skieur {
 	protected String nom;
	protected String prenom;
	protected String age;
	protected String poids;
	
	
	
	public Skieur(String nom) {
		super();
		this.nom = nom;
	}
	
	public Skieur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Skieur(String nom, String prenom, String age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Skieur(String nom, String prenom, String age, String poids) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.poids = poids;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getPoids() {
		return poids;
	}
	
	public void setPoids(String poids) {
		this.poids = poids;
	}
	
}