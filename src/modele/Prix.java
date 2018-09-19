package modele;

public class Prix {

    private String idPrix;
    private String idSkieur;
    private String titre;
    private String datePrix;
    private String temps;

    public Prix(String idPrix) {
        this.idPrix = idPrix;
    }

    public Prix(String idPrix, String idSkieur) {
        this.idPrix = idPrix;
        this.titre = titre;
    }

    public Prix(String idSkieur, String titre, String datePrix, String temps) {
        this.idSkieur = idSkieur;
        this.titre = titre;
        this.datePrix = datePrix;
        this.temps = temps;
    }

    public Prix(String idPrix, String idSkieur, String titre, String datePrix, String temps) {
        this.idPrix = idPrix;
        this.idSkieur = idSkieur;
        this.titre = titre;
        this.datePrix = datePrix;
        this.temps = temps;
    }


    public String getIdPrix() {
        return idPrix;
    }

    public void setIdPrix(String idPrix) {
        this.idPrix = idPrix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDatePrix() {
        return datePrix;
    }

    public void setDatePrix(String datePrix) {
        this.datePrix = datePrix;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getIdSkieur() {
        return idSkieur;
    }

    public void setIdSkieur(String idSkieur) {
        this.idSkieur = idSkieur;
    }
}
