package vue;
import action.Controleur;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Skieur;

public class VueSkieur extends Scene{
	
	protected Label valeurNom;
	protected Label valeurPrenom;
	protected Label valeurAge;
	protected Label valeurPoids;
	private Controleur controleur;

	public VueSkieur() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleSkieur = new GridPane();

		valeurNom = new Label("Jacobs");
		grilleSkieur.add(new Label("Nom : "), 0, 0);
		grilleSkieur.add(valeurNom, 1, 0);
		
		valeurPrenom = new Label("paul");
		grilleSkieur.add(new Label("Prenom : "), 0, 1);
		grilleSkieur.add(valeurPrenom, 1, 1);

		valeurAge = new Label("18 ans");
		grilleSkieur.add(new Label("Age : "), 0, 2);
		grilleSkieur.add(valeurAge, 1, 2);				
		
		valeurPoids = new Label("70 kg");
		grilleSkieur.add(new Label("Poids : "), 0, 3);
		grilleSkieur.add(valeurPoids, 1, 3);		
	
		panneau.getChildren().add(new Label("VueMouton"));
		panneau.getChildren().add(grilleSkieur);
		
		Skieur skieur = new Skieur("Jacobs", "paul", "18 ans", "70 kg");
		this.afficherSkieur(skieur);
	}
	
	public void afficherSkieur(Skieur skieur)
	{
		valeurNom.setText(skieur.getNom());
		valeurPrenom.setText(skieur.getPrenom());
		valeurAge.setText(skieur.getAge());
		valeurPoids.setText(skieur.getPoids());
	}


	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}
}