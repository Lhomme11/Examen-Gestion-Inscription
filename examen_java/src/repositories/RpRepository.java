package repositories;
import java.sql.SQLException;

import entities.Professeur;

public class RpRepository extends Database{
    private final  String SQL_INSERT="INSERT INTO `professeur` (`nci`,`filiere`,`niveau`) VALUES (?,?,?,?,?,?)";
    
      public void insert(Professeur professeur){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT);
             statement.setInt(1, professeur.getNci());
             statement.setString(2, professeur.getNomComplet());
             statement.setString(3, professeur.getGrade());
              int nbreLigne=statement.executeUpdate();
              closeConnexion();
            } catch (SQLException e) {
             e.printStackTrace();
            }
          
       }
    }

