package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Professeur;

public class ProfesseurRepository extends Database{
        private final String SQL_INSERT="INSERT INTO `professeur` (`nci`,`nomComplet`, `grade`) VALUES (?,?,?)";
        private final  String SQL_SELECT_ALL="select * from professeur" ;
        private final String SQL_LAST_VALUE_INSERT="SELECT Max(`idProfesseur`) as max FROM `Professeur`";
        private final  String SQL_SELECT_BY_ID="select * from professeur where idProfesseur like ?" ;
        public void insert(Professeur  Professeur){
            try {
                 openConnexion();
                 initPreparedStatement(SQL_INSERT);
                 statement.setInt(1,Professeur.getNci());
                 statement.setString(2,Professeur.getNomComplet());
                 statement.setString(3,Professeur.getGrade());

                 executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    
        public  Professeur selectLastProfesseur(){
            Professeur Professeur=null;
            try {
                openConnexion();
                initPreparedStatement(SQL_LAST_VALUE_INSERT);
         
                ResultSet rs = executeSelect();
                while (rs.next()) {
                    Professeur=new Professeur(); 
                    Professeur.setId(rs.getInt("max")); 
                 
                }
           } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           return Professeur;
          }
    public List<Professeur> selectAllProfesseur() {
        List<Professeur> professeurs= new ArrayList<>();
        try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_ALL);
            ResultSet rs= executeSelect();
                while (rs.next()) {
                    Professeur professeur=new Professeur();
                    professeur.setId(rs.getInt("idProfesseur"));
                    professeur.setNci(rs.getInt("nci"));
                    professeur.setNomComplet(rs.getString("nomcomplet"));
                    professeur.setGrade(rs.getString("grade"));
                    professeurs.add(professeur);
                }
                rs.close();
                closeConnexion();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur de Connexion à la BD");
        }
        return professeurs;
    }
    public Professeur selectProfesseurById(int id){
        Professeur professeur=null;
         try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_BY_ID);
           statement.setInt(1, id);
           ResultSet rs= executeSelect();
           if (rs.next()) {
            professeur=new Professeur();
            professeur.setId(rs.getInt("idProfesseur"));
            professeur.setNomComplet(rs.getString("nomComplet"));
            professeur.setGrade(rs.getString("grade"));
          }
          rs.close();
          closeConnexion();
       }
      catch (SQLException e) {
       System.out.println("Erreur de Connexion a la BD");
     }
      return  professeur;
     }
    }
    