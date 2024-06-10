package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Classe;
import entities.Filiere;
import entities.Niveau;

public class ClasseRepository extends Database {
    private final  String SQL_INSERT="INSERT INTO `classe` (`Filiere`,`Niveau`) VALUES (?,?)";
    private final  String SQL_SELECT_ALL="select * from classe" ;
    private final  String SQL_SELECT_BY_ID="select * from classe where idClasse like ?" ;
    
    public  void insertClasse(Classe classe){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT);
            statement.setDouble(1, classe.getFiliere().ordinal());       
            statement.setDouble(2, classe.getNiveau().ordinal());
            int nbreLigne=executeUpdate();
           closeConnexion();
         } catch (SQLException e) {
          e.printStackTrace();
         }
         }
         public  List<Classe> selectAllClasse(){
            List<Classe> classes=new ArrayList<>();
          try {
              openConnexion();
              initPreparedStatement(SQL_SELECT_ALL);
              ResultSet rs= executeSelect();
                while (rs.next()) {
                  Classe classe=new Classe();
                  classe.setId(rs.getInt("idClasse"));
                  int niveau=rs.getInt("niveau");
                  int filiere=rs.getInt("filiere");
                   classe.setNiveau(Niveau.values()[niveau]);
                   classe.setFiliere(Filiere.values()[filiere]);
                   classes.add(classe);
                }
                rs.close();
              closeConnexion();
           }
          catch (SQLException e) {
           System.out.println("Erreur de Connexion a la BD");
         }
           return  classes;
       }
    //   public List<Classe> selectAllClasse(){
    //      List<Classe> classes=new ArrayList<>();
    //       try {
    //         openConnexion();
    //         initPreparedStatement(SQL_SELECT_ALL);
    //         ResultSet rs= executeSelect();
    //         while (rs.next()) {
    //             Classe classe=new Classe();
    //             classe.setId(rs.getInt("id"));
    //             int niveau=rs.getInt("niveau");
    //             int filiere=rs.getInt("filiere");
    //                 classe.setNiveau(Niveau.values()[niveau]);
    //                 classe.setFiliere(Filiere.values()[filiere]);
    //                 classes.add(classe);
    //        }
    //        rs.close();
    //        closeConnexion();
    //     }
    //    catch (SQLException e) {
    //     System.out.println("Erreur de Connexion a la BD");
    //   }
    //    return  classes;
    //   }
      public Classe chercherClasseById(int id){
        Classe classe=null;
         try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_BY_ID);
           statement.setInt(1, id);
           ResultSet rs= executeSelect();
           if (rs.next()) {
            classe=new Classe();
            classe.setId(rs.getInt("idClasse"));
                int niveau=rs.getInt("niveau");
                int filiere=rs.getInt("filiere");
            classe.setFiliere(Filiere.values() [filiere]);
            classe.setNiveau(Niveau.values() [niveau]);            
          }

          rs.close();
          closeConnexion();
       }
      catch (SQLException e) {
       System.out.println("Erreur de Connexion a la BD");
     }
      return  classe;
     }
}
