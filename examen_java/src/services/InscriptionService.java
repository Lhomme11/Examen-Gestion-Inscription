package services;

import java.util.List;

import entities.Inscription;
import repositories.InscriptionRepository;

public class InscriptionService {
    InscriptionRepository inscriptionRepository= new InscriptionRepository();
    public void ajouterInscription (Inscription inscription){
        inscriptionRepository.insert(inscription);
    }
    public List<Inscription> listeInscriptionParAnnee(String anneeScolaire) {
        return inscriptionRepository.selectInscriptionParAnnee(anneeScolaire);
    }
    public List<Inscription> listeInscriptionParAnnee(String anneeScolaire, int idClasse) {
        return inscriptionRepository.selectInscriptionParAnnee(anneeScolaire, idClasse);
    }
    public Inscription chercherInscriptionEtudiantByMat(String matricule){
        return inscriptionRepository.selectInscriptionEtudiantByMat(matricule);
}
    
}
