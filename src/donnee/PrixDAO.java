package donnee;

import modele.Prix;
import modele.Skieur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrixDAO {

    Connection connection=null;

    public PrixDAO() {
        this.connection = BaseDeDonnees.getInstance().getConnection();
    }

    private List<Prix> simulerListePrix(){
        List<Prix> listePrix = new ArrayList<>();
        listePrix.add(new Prix("1","prix 1", "00-00-0000","1s"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000","1s"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000","1s"));
        listePrix.add(new Prix("1","prix 1", "00-00-0000","1s"));
        return listePrix;
    }

    public List<Prix> listerPrixParPatente(Skieur skieur){
        List<Prix> listeSkieur = new ArrayList<>();


        Statement requeteListeSkieurs = null;
        try {
            requeteListeSkieurs = connection.createStatement();
            ResultSet curseurListePrix = requeteListeSkieurs.executeQuery("SELECT * FROM prix WHERE id_skieur ="+skieur.getId());
            while (curseurListePrix.next())
            {
                String idSkieur = Integer.toString(skieur.getId());
                String titre = curseurListePrix.getString("titre");
                String date = curseurListePrix.getString("date_prix");
                String temps = curseurListePrix.getString("temps");

                listeSkieur.add(raporterprix(idSkieur,titre,date,temps));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeSkieur;
    }

    public Prix raporterprix(String idSkieur, String titre, String date, String temps)
    {
        return new Prix(idSkieur,titre, date,temps);
    }

    public void modifierPrix(Skieur skieur, Prix prix)
    {

    }

    public void ajouterPrix(Prix prix)
    {
        try {
            String requeteSQLAjouterSkieur = "INSERT  INTO prix(id_skieur,date_prix,temps,titre) VALUES('"+
                    prix.getIdSkieur()+"','"+
                    prix.getDatePrix()+"','"+
                    prix.getTemps()+"','"+
                    prix.getTitre()+"')";
            Statement requeteAjouterSkieurs = connection.createStatement();
            requeteAjouterSkieurs.execute(requeteSQLAjouterSkieur);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void effacerPrix(Prix prix)
    {

    }
}
