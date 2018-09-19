package modele;

public class Prix {

    private String idPrix;
    private String idSkieur;
    private String nomPrix;
    private String datePrix;
    private String temps;

    public Prix(String idPrix) {
        this.idPrix = idPrix;
    }

    public Prix(String idPrix, String idSkieur) {
        this.idPrix = idPrix;
        this.nomPrix = nomPrix;
    }

    public Prix(String idSkieur, String nomPrix, String datePrix, String temps) {
        this.idSkieur = idSkieur;
        this.nomPrix = nomPrix;
        this.datePrix = datePrix;
        this.temps = temps;
    }

    public Prix(String idPrix, String idSkieur, String nomPrix, String datePrix, String temps) {
        this.idPrix = idPrix;
        this.idSkieur = idSkieur;
        this.nomPrix = nomPrix;
        this.datePrix = datePrix;
        this.temps = temps;
    }


    public String getIdPrix() {
        return idPrix;
    }

    public void setIdPrix(String idPrix) {
        this.idPrix = idPrix;
    }

    public String getNomPrix() {
        return nomPrix;
    }

    public void setNomPrix(String nomPrix) {
        this.nomPrix = nomPrix;
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
