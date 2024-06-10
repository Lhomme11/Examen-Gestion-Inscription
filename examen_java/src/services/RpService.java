package services;



import entities.Professeur;
import repositories.RpRepository;

public class RpService {
    RpRepository rpRepository = new RpRepository();


    public void ajouterProfesseur (Professeur professeur){
        rpRepository.insert(professeur);
    }

    /*public List<Classe> listerProfesseur() {
        return rpRepository.selectAllProfesseur();
    }
    public List<Classe> filtrerClasseProfesseur(Professeur professeur) {
        return rpRepository.selectClasseByProf(professeur);
    }*/
}
