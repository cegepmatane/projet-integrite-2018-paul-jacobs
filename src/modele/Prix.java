package modele;

public class Prix {

    private String idPrix;
    private String nomPrix;
    private String datePrix;
    private String temps;
    private String place;

    public Prix(String idPrix) {
        this.idPrix = idPrix;
    }

    public Prix(String idPrix, String nomPrix) {
        this.idPrix = idPrix;
        this.nomPrix = nomPrix;
    }

    public Prix(String idPrix, String nomPrix, String datePrix) {
        this.idPrix = idPrix;
        this.nomPrix = nomPrix;
        this.datePrix = datePrix;
    }

    public Prix(String idPrix, String nomPrix, String datePrix, String temps) {
        this.idPrix = idPrix;
        this.nomPrix = nomPrix;
        this.datePrix = datePrix;
        this.temps = temps;
    }

    public Prix(String idPrix, String nomPrix, String datePrix, String temps, String place) {
        this.idPrix = idPrix;
        this.nomPrix = nomPrix;
        this.datePrix = datePrix;
        this.temps = temps;
        this.place = place;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}