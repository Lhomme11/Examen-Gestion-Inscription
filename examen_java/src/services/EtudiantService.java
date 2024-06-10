package services;

import entities.Etudiant;
import repositories.EtudiantRepository;

public class EtudiantService {
        EtudiantRepository etudiantRepository=new EtudiantRepository();
        public void ajoutEtudiant(Etudiant etudiant){
        etudiantRepository.insert(etudiant);
    }
public Etudiant chercherEtudiantByMat(String matricule){
        return etudiantRepository.selectEtudiantByMat(matricule);
}
}
