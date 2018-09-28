package donnee;

public interface SkieurSQL {
    public static final String SQL_LISTER_SKIEUR = "SELECT * FROM skieur";
    public static final String SQL_AJOUTER_SKIEUR = "INSERT INTO skieur(nom, prenom, age, poids) VALUES(?,?,?,?)";
    public static final String SQL_MODIFIER_SKIEUR = "UPDATE skieur SET nom=?, prenom=?, age=?, poids=? WHERE id=?";
    public static final String SQL_RAPPORTER_SKIEUR = "SELECT * FROM skieur WHERE id=?";
    public static final String SQL_SUPPRIMER_SKIEUR = "DELETE FROM skieur WHERE id=?";
}
