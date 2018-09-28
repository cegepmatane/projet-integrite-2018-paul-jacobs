package donnee;

import modele.Prix;
import modele.Skieur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrixDAO implements PrixSQL{

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

        try {
            PreparedStatement requeteListeSkieurs = connection.prepareStatement(SQL_LISTER_PRIX_PAR_ID_SKIEUR);
            requeteListeSkieurs.setInt(1,skieur.getId());
            ResultSet curseurListePrix = requeteListeSkieurs.executeQuery();
            while (curseurListePrix.next())
            {
                String id = curseurListePrix.getString("id");
                String idSkieur = curseurListePrix.getString("id_skieur");
                String titre = curseurListePrix.getString("titre");
                String date = curseurListePrix.getString("date_prix");
                String temps = curseurListePrix.getString("temps");

                listeSkieur.add(raporterprix(id,idSkieur,titre,date,temps));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeSkieur;
    }

    public Prix raporterprix(String id, String idSkieur, String titre, String date, String temps)
    {
        return new Prix(id, idSkieur,titre, date,temps);
    }

    public void modifierPrix(Prix prix)
    {
        try {
            PreparedStatement requeteModifierPrix = connection.prepareStatement(SQL_MODIFIER_PRIX);
            requeteModifierPrix.setString(1,prix.getTitre());
            requeteModifierPrix.setString(2,prix.getDatePrix());
            requeteModifierPrix.setString(3,prix.getTemps());
            requeteModifierPrix.setInt(4,Integer.parseInt(prix.getIdPrix()));
            requeteModifierPrix.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterPrix(Prix prix)
    {
        try {
            PreparedStatement requeteAjouterPrix = connection.prepareStatement(SQL_AJOUTER_PRIX);
            requeteAjouterPrix.setInt(1,Integer.parseInt(prix.getIdSkieur()));
            requeteAjouterPrix.setString(2,prix.getDatePrix());
            requeteAjouterPrix.setString(3,prix.getTemps());
            requeteAjouterPrix.setString(4,prix.getTitre());
            requeteAjouterPrix.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerPrix(Prix prix)
    {
        try {
            PreparedStatement requeteSupprimerPrix = connection.prepareStatement(SQL_SUPPRIMER_PRIX);
            requeteSupprimerPrix.setInt(1, Integer.parseInt(prix.getIdPrix()));
            requeteSupprimerPrix.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
