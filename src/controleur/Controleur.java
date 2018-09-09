package controleur;

import vue.NavigateurVueSkieur;

public class Controleur {

    private NavigateurVueSkieur navigateurVueSkieur;

    public Controleur(NavigateurVueSkieur navigateurVueSkieur){
        this.navigateurVueSkieur = navigateurVueSkieur;
        this.navigateurVueSkieur.naviguerVersVueListeSkieur();
    }
}
