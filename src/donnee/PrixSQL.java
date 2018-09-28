package donnee;

public interface PrixSQL {
    public static final String SQL_LISTER_PRIX_PAR_ID_SKIEUR="SELECT * FROM prix WHERE id_skieur=?";
    public static final String SQL_MODIFIER_PRIX="UPDATE prix SET titre=?,date_prix=?,temps=?  WHERE id = ?";
    public static final String SQL_AJOUTER_PRIX="INSERT  INTO prix(id_skieur,date_prix,temps,titre) VALUES(?,?,?,?)";
    public static final String SQL_SUPPRIMER_PRIX="DELETE FROM prix WHERE id=?";
}
