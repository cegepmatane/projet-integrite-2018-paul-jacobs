package donnee;

import modele.Skieur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkieurDAO implements SkieurSQL{

    Connection connection=null;

    public SkieurDAO(){
        this.connection = BaseDeDonnees.getInstance().getConnection();
    }

     /*private List<Skieur> simulerListeSkieur(){

        List<Skieur> listeSkieur = new ArrayList<Skieur>();

        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));
        listeSkieur.add(new Skieur("Jacobs", "paul", "18 ans", "70 kg"));

        return listeSkieur;
    }*/

    public List<Skieur> listerSkieur() {

        List<Skieur> listeSkieur = new ArrayList<Skieur>();


        Statement requeteListeSkieurs = null;
        try {
            requeteListeSkieurs = connection.createStatement();
            ResultSet curseurListeSkieurs = requeteListeSkieurs.executeQuery(SQL_LISTER_SKIEUR);
             while (curseurListeSkieurs.next())
             {
                 int id = curseurListeSkieurs.getInt("id");
                 String nom = curseurListeSkieurs.getString("nom");
                 String prenom = curseurListeSkieurs.getString("prenom");
                 String age = curseurListeSkieurs.getString("age");
                 String poids = Integer.toString(curseurListeSkieurs.getInt("poids"));

                 listeSkieur.add(new Skieur(id,nom,prenom,age,poids));

             }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeSkieur;
    }

    public Skieur raporterSkieur(int id, String nom, String prenom, String age, String poids)
    {
        try{
            PreparedStatement requeteSkieur = connection.prepareStatement(SQL_RAPPORTER_SKIEUR);
            requeteSkieur.setString(1,Integer.toString(id));

            ResultSet resultatRequete = requeteSkieur.executeQuery();
            resultatRequete.next();

            int idSkieur = resultatRequete.getInt("id");
            String nomSkieur = resultatRequete.getString("nom");
            String prenomSkieur = resultatRequete.getString("prenom");
            String ageSkieur = resultatRequete.getString("age");
            String poidsSkieur = Integer.toString(resultatRequete.getInt("poids"));
            Skieur skieur = new Skieur(idSkieur,nomSkieur,prenomSkieur,ageSkieur,poidsSkieur);
            return skieur;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void ajouterSkieur(Skieur skieur)
    {

        try {

            PreparedStatement requeteAjouterSkieur = connection.prepareStatement(SQL_AJOUTER_SKIEUR);
            requeteAjouterSkieur.setString(1, skieur.getNom());
            requeteAjouterSkieur.setString(2, skieur.getPrenom());
            requeteAjouterSkieur.setString(3, skieur.getAge());
            requeteAjouterSkieur.setInt(4, Integer.parseInt(skieur.getPoids()));
            requeteAjouterSkieur.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierSkieur(Skieur skieur) {
        try {
            PreparedStatement requeteModifierSkieur = connection.prepareStatement(SQL_MODIFIER_SKIEUR);
            requeteModifierSkieur.setString(1, skieur.getNom());
            requeteModifierSkieur.setString(2, skieur.getPrenom());
            requeteModifierSkieur.setString(3, skieur.getAge());
            requeteModifierSkieur.setInt(4, Integer.parseInt(skieur.getPoids()));
            requeteModifierSkieur.setInt(5, skieur.getId());
            requeteModifierSkieur.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerSkieur(Skieur skieur)
    {
        try {
            PreparedStatement supprimerSkieur = connection.prepareStatement(SQL_SUPPRIMER_SKIEUR);
            supprimerSkieur.setInt(1,skieur.getId());
            supprimerSkieur.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
