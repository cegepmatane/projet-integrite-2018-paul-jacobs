package vue;

import action.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modele.Prix;
import modele.Skieur;

import java.util.ArrayList;
import java.util.List;


public class VueModifierSkieur extends Scene {

    private Button actionModifierSkieur;
    private GridPane grilleAffichage;
    private GridPane grilleAffichagePrix;
    private GridPane grilleModifierSkieur;

    private Controleur controleur;
    private TextField valeurNom;
    private TextField valeurPrenom;
    private TextField valeurAge;
    private TextField valeurPoids;

    public VueModifierSkieur() {
        super(new GridPane(),400,400);
        this.grilleAffichage = (GridPane) this.getRoot();

        this.grilleModifierSkieur = new GridPane();
        this.grilleAffichagePrix = new GridPane();

        this.actionModifierSkieur = new Button("enregistrer");

        this.actionModifierSkieur.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Skieur skieur = recupererSkieur();
                controleur.modifierSkieur(skieur);
            }
        });
    }

    public void afficherGrillerModifierSkieur(Skieur skieur)
    {
        this.grilleAffichage.getChildren().clear();
        this.grilleModifierSkieur.getChildren().clear();
        this.grilleAffichagePrix.getChildren().clear();
        this.grilleModifierSkieur.add(new Label("Nom : "), 0, 0);
        this.grilleModifierSkieur.add(new Label("Prenom : "), 0, 1);
        this.grilleModifierSkieur.add(new Label("Age : "), 0, 2);
        this.grilleModifierSkieur.add(new Label("Poids : "), 0, 3);



        valeurNom = new TextField(skieur.getNom());
        valeurPrenom = new TextField(skieur.getPrenom());
        valeurAge = new TextField(skieur.getAge());
        valeurPoids = new TextField(skieur.getPoids());

        this.grilleModifierSkieur.add(valeurNom,1,0);
        this.grilleModifierSkieur.add(valeurPrenom,1,1);
        this.grilleModifierSkieur.add(valeurAge,1,2);
        this.grilleModifierSkieur.add(valeurPoids,1,3);
        this.grilleAffichage.add(grilleModifierSkieur,0,0);
        afficherGrillePrix(skieur);
        this.grilleAffichage.add(actionModifierSkieur,0,5);

    }

    private void afficherGrillePrix(Skieur skieur)
    {
        List<Prix> listePrix = new ArrayList<>();
        grilleAffichagePrix.add(new Label("nom"),0,0);
        grilleAffichagePrix.add(new Label("date"),1,0);
        grilleAffichagePrix.add(new Label("temps"),2,0);
        grilleAffichagePrix.add(new Label("place"),3,0);

        listePrix.add(new Prix("0", "trophee", "00-00-0000", "1s","1er"));
        listePrix.add(new Prix("1", "tropheee", "00-00-0000", "1s","1er"));
        listePrix.add(new Prix("2", "tropheee", "00-00-0000", "1s","1er"));

        int numero = 0;
        for(Prix prix : listePrix)
        {
            Button actionModifierPrix = new Button("modifier");
            actionModifierPrix.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controleur.naviguerVersVueModifierPrix(prix, skieur);
                }
            });

            numero++;
            grilleAffichagePrix.add(new Label(prix.getNomPrix()), 0,numero);
            grilleAffichagePrix.add(new Label(prix.getDatePrix()), 1,numero);
            grilleAffichagePrix.add(new Label(prix.getTemps()), 2,numero);
            grilleAffichagePrix.add(new Label(prix.getPlace()), 3,numero);
            this.grilleAffichagePrix.add(actionModifierPrix, 4, numero);
            grilleAffichagePrix.add(new Button("supprimer"), 5, numero);
        }

        Button actionAjouterPrix = new Button("ajouter");
        actionAjouterPrix.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controleur.naviguerVersVueAjouterPrix();
            }
        });

        this.grilleAffichagePrix.add(actionAjouterPrix,0,numero+1);

        this.grilleAffichage.add(grilleAffichagePrix,0,4);
    }

    private Skieur recupererSkieur(){
        Skieur skieur = new Skieur(
                this.valeurNom.getText(),
                this.valeurPrenom.getText(),
                this.valeurAge.getText(),
                this.valeurPoids.getText()
        );
        return skieur;
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
}
