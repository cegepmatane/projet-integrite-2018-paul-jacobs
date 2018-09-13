package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnees {

    private String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
    private String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/skieur";
    private String BASEDEDONNEES_USAGER = "postgres";
    private String BASEDEDONNEES_MOTDEPASSE = "toto";
    private static BaseDeDonnees baseDeDonnees=null;
    private Connection connection=null;

    private BaseDeDonnees()
    {
        try {
            Class.forName(BASEDEDONNEES_DRIVER);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
        } catch (
        SQLException e) {
            e.printStackTrace();
        }
    }

    //DEBUT SINGLETON
    public static  BaseDeDonnees getInstance()
    {
        if (baseDeDonnees==null)
            baseDeDonnees = new BaseDeDonnees();
        return baseDeDonnees;
    }


    //FIN SINGLETON


    public Connection getConnection()
    {
        return connection;
    }
}
