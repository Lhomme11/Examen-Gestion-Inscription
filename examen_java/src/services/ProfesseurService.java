package services;

import java.util.List;
import entities.Professeur;
import entities.ProfesseurEtClasse;
import repositories.ProfesseurEtClasseRepository;
import repositories.ProfesseurRepository;

public class ProfesseurService {
ProfesseurRepository professeurRepository=new ProfesseurRepository();
ProfesseurEtClasseRepository professeurEtClasseRepository=new ProfesseurEtClasseRepository();
public void ajoutProfesseur(Professeur professeur){
    professeurRepository.insert(professeur);
    Professeur lastProfesseur= professeurRepository.selectLastProfesseur();
    List<ProfesseurEtClasse> professeurEtClasse = professeur.getProfesseurEtClasse();
    for (ProfesseurEtClasse pcl  : professeurEtClasse) {
        pcl.setProfesseur(lastProfesseur);
        professeurEtClasseRepository.insert(pcl);

    }
}
public List<Professeur> listeProfesseurs(){
    return professeurRepository.selectAllProfesseur();
}
public Professeur selectProfesseurById(int id) {
    return professeurRepository.selectProfesseurById(id);
}
  
}
