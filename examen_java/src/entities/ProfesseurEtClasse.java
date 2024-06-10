package entities;

public class ProfesseurEtClasse {
    int  idProfesseur;
    Professeur professeur;
    Classe  classe;
    
    public int getIdProfesseur() {
        return idProfesseur;
    }
    public void setIdProfesseur(int idProfesseur) {
        this.idProfesseur = idProfesseur;
    }
    public Professeur getProfesseur() {
        return professeur;
    }
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }


}
