package services;

import java.util.List;
import entities.Classe;
import repositories.ClasseRepository;

public class ClasseService {
    ClasseRepository classeRepository = new ClasseRepository();
        public void ajouterClasse(Classe classe){
        classeRepository.insertClasse(classe);
    }
    public List<Classe> listerClasse() {
        return classeRepository.selectAllClasse();
    }
    public Classe chercherClasseById(int id) {
        return classeRepository.chercherClasseById(id);
    }
}

