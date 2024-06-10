package repositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Etudiant;
import entities.Inscription;

public class InscriptionRepository extends Database {
    private final  String SQL_INSERT="INSERT INTO `inscription` (`anneeScolaire`,`matricule`,`idClasse`) VALUES (?,?,?)";
    private final  String SQL_SELECT_ALL="select * from inscription i, etudiant e where i.matricule=e.matricule and i.anneeScolaire like ?" ;
    private final  String SQL_SELECT_PAR_ANNEE="select * from inscription i, etudiant e where i.matricule=e.matricule and i.anneeScolaire like ? and i.idClasse like ? " ;
    private final  String SQL_SELECT_BY_MATRICULE="select * from inscription where matricule like ?" ;
    public void insert(Inscription inscription) {
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT);
             statement.setString(1, inscription.getAnneeScolaire());
             statement.setString(2, inscription.getEtudiant().getMatricule());
             statement.setInt(3, inscription.getClasse().getId());
             int nbreLigne=executeUpdate();
              closeConnexion();
            } catch (SQLException e) {
             e.printStackTrace();
            }
          
       }
       public List<Inscription> selectInscriptionParAnnee(String anneeScolaire){
         List<Inscription> inscriptions=new ArrayList<>();
          try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_ALL);
            statement.setString(1,anneeScolaire);
            ResultSet rs= executeSelect();
            while (rs.next()) {
                Inscription inscription=new Inscription();
                inscription.setId(rs.getInt("id"));
                inscription.setAnneeScolaire(rs.getString("anneeScolaire"));
                Etudiant etudiant=new Etudiant();
                etudiant.setMatricule(rs.getString("matricule"));
                etudiant.setNomComplet(rs.getString("nomComplet"));
                etudiant.setTuteur(rs.getString("tuteur"));
                inscription.setEtudiant(etudiant);
                inscriptions.add(inscription);

            }
           rs.close();
           closeConnexion();
        }
       catch (SQLException e) {
        System.out.println("Erreur de Connexion a la BD");
      }
       return  inscriptions;
      }
      public List<Inscription> selectInscriptionParAnnee(String anneeScolaire, int idClasse){
        List<Inscription> inscriptions=new ArrayList<>();
         try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_PAR_ANNEE);
           statement.setString(1,anneeScolaire);
           statement.setInt(2,idClasse);
           ResultSet rs= executeSelect();
           while (rs.next()) {
               Inscription inscription=new Inscription();
               inscription.setId(rs.getInt("id"));
               inscription.setAnneeScolaire(rs.getString("anneeScolaire"));
               Etudiant etudiant=new Etudiant();
               etudiant.setMatricule(rs.getString("matricule"));
               etudiant.setNomComplet(rs.getString("nomComplet"));
               etudiant.setTuteur(rs.getString("tuteur"));
               inscription.setEtudiant(etudiant);
               inscriptions.add(inscription);

           }
          rs.close();
          closeConnexion();
       }
      catch (SQLException e) {
       System.out.println("Erreur de Connexion a la BD");
     }
      return  inscriptions;
     }
     public Inscription selectInscriptionEtudiantByMat(String mat){
        Inscription inscription=null;
         try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_BY_MATRICULE);
           statement.setString(1, mat);
           ResultSet rs= executeSelect();
           if (rs.next()) {
               inscription=new Inscription();
               inscription.setId(rs.getInt("id"));
               inscription.setAnneeScolaire(rs.getString("anneeScolaire"));
               Etudiant etudiant=new Etudiant();
               etudiant.setMatricule(rs.getString("matricule"));
               etudiant.setNomComplet(rs.getString("nomComplet"));
               etudiant.setTuteur(rs.getString("tuteur"));
               inscription.setEtudiant(etudiant);
            }
          rs.close();
          closeConnexion();
       }
      catch (SQLException e) {
       System.out.println("Erreur de Connexion a la BD");
     }
      return  inscription;
     }

}

