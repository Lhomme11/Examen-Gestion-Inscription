package repositories;

import java.sql.SQLException;

import entities.ProfesseurEtClasse;

public class ProfesseurEtClasseRepository extends Database {
    
    private final String SQL_INSERT="INSERT INTO `ProfesseurEtClasse` (`idClasse`, `idProfesseur`) VALUES (?,?);";
    public void insert(ProfesseurEtClasse  professeurEtClasse){
        try {
             openConnexion();
             initPreparedStatement(SQL_INSERT);
             statement.setInt(1,professeurEtClasse.getClasse().getId());
             statement.setInt(2,professeurEtClasse.getProfesseur().getId());
             executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 
    
}

