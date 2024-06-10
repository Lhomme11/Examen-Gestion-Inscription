package entities;

import java.util.List;

public class Professeur {
    private int  id;
    private int nci;
    private String nomComplet;
    private String grade;
    List<ProfesseurEtClasse> professeurEtClasse;
    
    public List<ProfesseurEtClasse> getProfesseurEtClasse() {
        return professeurEtClasse;
    }
    public void setProfesseurEtClasse(List<ProfesseurEtClasse> professeurDeClasses) {
        this.professeurEtClasse = professeurDeClasses;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNci() {
        return nci;
    }
    public void setNci(int nci) {
        this.nci = nci;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
}
